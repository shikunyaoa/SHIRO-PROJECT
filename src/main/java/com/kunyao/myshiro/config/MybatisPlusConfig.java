package com.kunyao.myshiro.config;


import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: MybatisPlusConfig
 * @Author: kunyao
 * @Description: mybatis-plus配置文件
 * @Date: 2019/12/6 14:29
 * @Version: 1.0
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.kunyao.myshiro.mapper*")
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**
     * mybatis-plus乐观锁插件
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
}
