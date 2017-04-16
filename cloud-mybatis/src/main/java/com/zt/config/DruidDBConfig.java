package com.zt.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 自定义读取yml文件初始化配置
 */
@Configuration
@ConfigurationProperties(locations = {"classpath:druid.yml"}, prefix = "druid")
public class DruidDBConfig {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DruidDBConfig.class);

//    @Value("${spring.datasource.url}")
    private String url;

//    @Value("${spring.datasource.username}")
    private String username;

//    @Value("${spring.datasource.password}")
    private String password;

//    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

//    @Value("${spring.datasource.initialSize}")
    private int initialSize;

//    @Value("${spring.datasource.minIdle}")
    private int minIdle;

//    @Value("${spring.datasource.maxActive}")
    private int maxActive;

//    @Value("${spring.datasource.maxWait}")
    private int maxWait;

//    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

//    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

//    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

//    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

//    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

//    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

//    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

//    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

//    @Value("${spring.datasource.filters}")
    private String filters;

//    @Value("{spring.datasource.connectionProperties}")
    private String connectionProperties;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public int getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public int getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public boolean getPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public void setPoolPreparedStatements(boolean poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }

    public int getMaxPoolPreparedStatementPerConnectionSize() {
        return maxPoolPreparedStatementPerConnectionSize;
    }

    public void setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getConnectionProperties() {
        return connectionProperties;
    }

    public void setConnectionProperties(String connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();
        logger.info("url: {} userName: {} password: {} driverClassName:{} ", getUrl(), getUsername(), getPassword(), getDriverClassName());
        datasource.setUrl(getUrl());
        datasource.setUsername(getUsername());
        datasource.setPassword(getPassword());
        datasource.setDriverClassName(getDriverClassName());

        //configuration
        datasource.setInitialSize(getInitialSize());
        datasource.setMinIdle(getMinIdle());
        datasource.setMaxActive(getMaxActive());
        datasource.setMaxWait(getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(getValidationQuery());
        logger.info("getInitialSize: {} getMinIdle: {} getMaxActive: {} getMaxWait:{} getTimeBetweenEvictionRunsMillis: {} getMinEvictableIdleTimeMillis: {} getValidationQuery: {}",
                getInitialSize(), getMinIdle(), getMaxActive(), getMaxWait(), getTimeBetweenEvictionRunsMillis(), getMinEvictableIdleTimeMillis(), getValidationQuery());
        datasource.setTestWhileIdle(getTestWhileIdle());
        datasource.setTestOnBorrow(getTestOnBorrow());
        datasource.setTestOnReturn(getTestOnReturn());
        logger.info("testWhileIdle: {} testOnBorrow: {} testOnReturn: {} poolPreparedStatements: {} MaxPoolPreparedStatementPerConnectionSize: {}",
                getTestWhileIdle(), getTestOnBorrow(), getTestOnReturn(), getPoolPreparedStatements(), getMaxPoolPreparedStatementPerConnectionSize());
        datasource.setPoolPreparedStatements(getPoolPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(getMaxPoolPreparedStatementPerConnectionSize());
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(connectionProperties);

        return datasource;
    }

}
