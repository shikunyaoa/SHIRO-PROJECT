package com.kunyao.myshiro.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;

/**
 * @ClassName: MultipartConfig
 * @Author: kunyao
 * @Description: 文件上传大小限制
 * @Date: 2019/12/6 14:32
 * @Version: 1.0
 */
@Configuration
public class MultipartConfig {

    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();

        //单个文件大小
        factory.setMaxFileSize(DataSize.of(100, DataUnit.MEGABYTES));

        //设置总上传数据大小
        factory.setMaxRequestSize(DataSize.of(100, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }
}
