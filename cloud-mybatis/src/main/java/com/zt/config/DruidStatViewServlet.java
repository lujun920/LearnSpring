package com.zt.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * 配置等价于使用web.xml配置
 * <servlet>
 *      <servlet-name>DruidStatView</servlet-name>
 *      <servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
 * </servlet>
 * <servlet-mapping>
 *      <servlet-name>DruidStatView</servlet-name>
 *      <url-pattern>/druid/*</url-pattern>
 * </servlet-mapping>
 * Created by lujun on 2017/4/16.
 */
@WebServlet(urlPatterns="/druid/*",
        initParams={
                @WebInitParam(name="allow",value="127.0.0.1"),// IP白名单(没有配置或者为空，则允许所有访问)
                @WebInitParam(name="deny",value="192.168.1.73"),// IP黑名单 (存在共同时，deny优先于allow)
                @WebInitParam(name="loginUsername",value="admin"),// 用户名
                @WebInitParam(name="loginPassword",value="123456"),// 密码
                @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
        })
public class DruidStatViewServlet extends StatViewServlet {
    private static final long serialVersionUID = 1L;
}
