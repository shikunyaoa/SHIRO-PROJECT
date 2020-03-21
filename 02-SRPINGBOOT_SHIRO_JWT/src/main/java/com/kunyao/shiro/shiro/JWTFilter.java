package com.kunyao.shiro.shiro;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kunyao.shiro.config.ResponseHelper;
import com.kunyao.shiro.config.ResponseModel;
import com.kunyao.shiro.constant.PublicConstant;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName: JWTFilter
 * @Author: kunyao
 * @Description: 自定义过滤器
 * @Date: 2019/12/12 15:58
 * @Version: 1.0
 */

public class JWTFilter extends BasicHttpAuthenticationFilter {



    private static final String AUTHZ_HEADER = "Bearer ";

    private static final String EXPIRE_FLAG = "expiredJwt";
    /**
     * 判断用户是否想要登录
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("Authorization").replace(AUTHZ_HEADER, "");
        return authorization != null;
    }


    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authorization = httpServletRequest.getHeader("Authorization").replace(AUTHZ_HEADER, "");
        JWTToken token = new JWTToken(authorization);
        //提交给Authenticator进行登入
        getSubject(request, response).login(token);
        return true;
    }

    /**
     * executeLogin拿到token进行登录，成功后调用subject的isPermitted()方法校验权限，否则抛出异常
     * 如果访问的url没有被授权则会拒绝访问，走访问拒绝的处理逻辑onAccessDenied, 有则放行
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        if(isLoginAttempt(request, response)){
            try {
                executeLogin(request, response);
            } catch (Exception e) {
                if (EXPIRE_FLAG.equals(e.getMessage())) {
                    responseError(request, response);
                }
                responseError(request, response);
            }
        }else{
            responseError(request, response);
        }
        Subject subject = getSubject(request, response);
        String url = getPathWithinApplication(request);
        //提交给Authorizer进行权限校验
        return subject.isPermitted(url);
    }

    /**
     * 当isAccessAllowed 返回false的时候执行该方法
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse resp = (HttpServletResponse)response;
        resp.setCharacterEncoding("UTF8");
        resp.setContentType("application/json; charset=utf8");
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseModel responseModel = ResponseHelper.validationFailure("当前用户无该接口权限");
        PrintWriter printWriter = response.getWriter();
        printWriter.append(objectMapper.writeValueAsString(responseModel));
        return false;
    }
    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }

        return super.preHandle(request, response);
    }


    /**
     * 非法url返回身份错误信息
     */
    private void responseError(ServletRequest request, ServletResponse response) {
        PrintWriter out = null;
        try {

            response.setCharacterEncoding("utf-8");
            out = response.getWriter();
            response.setContentType("application/json; charset=utf-8");
            out.print(JSONObject.toJSONString(ResponseHelper.response401(PublicConstant.UNAUTHORIZED)));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                out.close();
            }
        }
    }





}
