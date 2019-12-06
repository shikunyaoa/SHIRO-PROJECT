package com.kunyao.myshiro.service.impl;

import com.kunyao.myshiro.entity.Log;
import com.kunyao.myshiro.mapper.LogMapper;
import com.kunyao.myshiro.service.ILogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author kunyao123
 * @since 2019-12-06
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
