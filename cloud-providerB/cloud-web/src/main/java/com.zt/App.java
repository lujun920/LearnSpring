package com.zt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p/>类文件: com.zt
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/10 16:25
 */
@EnableDiscoveryClient
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class).web(true).run(args);
    }

}
