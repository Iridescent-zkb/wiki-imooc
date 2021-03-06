package com.zkb.wiki.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
扫描多个包的写法，json
 @ComponentScan({"com.zkb","com.test"})
 */
@ComponentScan("com.zkb")
@SpringBootApplication
@MapperScan("com.zkb.wiki.mapper")
@EnableScheduling
@EnableAsync
public class WikiApplication {

     private static final Logger LOG = LoggerFactory.getLogger(WikiApplication.class);
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WikiApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("地址：\t http://127.0.0.1：{}",env.getProperty("server.port"));
    }

}
