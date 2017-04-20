package com.zt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p/>类文件: com.zt.EurekaApplication.java
 * <p/>类功能描述: 注册中心服务
 *
 * @作者: luj
 * @时间: 2017/4/20 13:45
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication{
    public static void main(String[] args){
        new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
    }
}
