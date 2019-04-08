package com.hhx.shard;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 启动
 *
 * @author hhx
 */
@SpringBootApplication
public class ShardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardApplication.class, args);
    }

    /**
     * mybatis-plus分页插件
     * 文档：http://mp.baomidou.com
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
