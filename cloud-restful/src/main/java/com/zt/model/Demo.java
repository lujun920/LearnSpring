package com.zt.model;

import java.io.Serializable;

/**
 * <p/>类文件: com.zt.model
 * <p/>类功能描述: ${todo}
 *
 * @作者: luj
 * @时间: 2017/4/7 11:04
 */
public class Demo implements Serializable{
    private Integer id;
    private String name;
    private Integer age;
    private String context;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
