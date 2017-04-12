package com.zt;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Hello world!
 *
 */
@EnableZuulProxy
@SpringCloudApplication
public class App {
    public static void main( String[] args ){
        new SpringApplicationBuilder(App.class).web(true).run(args);
    }
}
