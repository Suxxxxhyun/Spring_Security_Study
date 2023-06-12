package com.eazybytes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Customer {
    @Id //기본키
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native") //데이터베이스에 기본키의 대한 id값 자동 증가
    @GenericGenerator(name = "native",strategy = "native") //시퀀스 자동 생성 및 증가
    private int id;
    private String name;
    private String email;

    //@JsonProperty - 자바의 카멜케이스와 json의 스네이크케이스로 인한 컬럼명이
    //일치하지 않어 서로 매핑시켜주는 어노테이션!
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    @Column(name = "mobile_number")
    private String mobileNumber;

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    private String role;

    @Column(name = "create_dt")
    private String createDt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
