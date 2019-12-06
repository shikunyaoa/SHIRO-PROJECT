package com.kunyao.myshiro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Swagger4jConfig
 * @Author: kunyao
 * @Description: Swagger2配置文件
 * @Date: 2019/12/6 13:46
 * @Version: 1.0
 */
@Configuration
@EnableSwagger2
public class Swagger4jConfig {

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.base.package}")
    private String basePackage;

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.url}")
    private String url;

    @Value("${swagger.contact.name}")
    private String contactName;

    @Value("${swagger.contact.url}")
    private String contactUrl;

    @Value("${swagger.contact.email}")
    private String contactEmail;

    @Value("${swagger.version}")
    private String version;

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(url)
                .contact(new Contact(contactName, contactUrl, contactEmail))
                .version(version)
                .build();
    }


}
