package com.zt.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 配置等价于web.xml配置
 * <filter>
 *      <filter-name>DruidWebStatFilter</filter-name>
 *      <filter-class>com.alibaba.druid.support.http.WebStatFilter</filter-class>
 *      <init-param>
 *          <param-name>exclusions</param-name>
 *          <param-value>*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*</param-value>
 *      </init-param>
 * </filter>
 * <filter-mapping>
 *      <filter-name>DruidWebStatFilter</filter-name>
 *      <url-pattern>/*</url-pattern>
 * </filter-mapping>
 * Created by lujun on 2017/4/16.
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源
        }
)
public class DruidStatFilter extends WebStatFilter {
}
