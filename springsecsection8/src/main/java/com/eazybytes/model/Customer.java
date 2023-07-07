package com.eazybytes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
public class Customer {
    @Id //기본키
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native") //데이터베이스에 기본키의 대한 id값 자동 증가
    @GenericGenerator(name = "native",strategy = "native") //시퀀스 자동 생성 및 증가
    @Column(name = "customer_id")
    private int id;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    //@JsonProperty - 자바의 카멜케이스와 json의 스네이크케이스로 인한 컬럼명이
    //일치하지 않어 서로 매핑시켜주는 어노테이션!
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    private String role;

    @Column(name = "create_dt")
    private String createDt;

    //@JsonIgnore - https://tech-monster.tistory.com/m/111
    //어떠한 엔터티를 기준으로 조회할때, 해당 필드를 제외하여 조회하길 원할때 사용(그 필드가 중요한 정보라면 @JsonIgnore어노테이션을 사용한다.)
    //fetch=FetchType.EAGER은 Customer 엔터티를 조회할때 조인된 Authority의 정보까지 같이 조회되길 원할 때 사용한다.
    //https://velog.io/@jin0849/JPA-%EC%A6%89%EC%8B%9C%EB%A1%9C%EB%94%A9EAGER%EA%B3%BC-%EC%A7%80%EC%97%B0%EB%A1%9C%EB%94%A9LAZY참조
    @JsonIgnore
    @OneToMany(mappedBy="customer",fetch=FetchType.EAGER)
    private Set<Authority> authorities;

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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreateDt() {
        return createDt;
    }

    public void setCreateDt(String createDt) {
        this.createDt = createDt;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
