package com.example.demo.entity;

import java.io.Serializable;

/**
 * (Staff)实体类
 *
 * @author makejava
 * @since 2022-01-04 14:10:51
 */
public class Staff implements Serializable {
    private static final long serialVersionUID = -61898315031253318L;

    private Integer workNum;

    private String name;

    private String depNum;

    private String phone;

    private String password;

    private Boolean state;

    private Boolean inService;

    public Boolean getInService() {
        return inService;
    }

    public void setInService(boolean inService) {
        this.inService = inService;
    }

    public Integer getWorkNum() {
        return workNum;
    }

    public void setWorkNum(Integer workNum) {
        this.workNum = workNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepNum() {
        return depNum;
    }

    public void setDepNum(String depNum) {
        this.depNum = depNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

}

