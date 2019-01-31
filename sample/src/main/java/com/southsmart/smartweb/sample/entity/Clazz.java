package com.southsmart.smartweb.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "DEMO_CLASS")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Clazz {
    //班级
    @Id
    @GenericGenerator(name = "id", strategy = "guid")
    @GeneratedValue(generator = "id")
    @Column(name = "ID", unique = true, nullable = false)
    private String id;
    
    //名称
    @Column(name = "C_NAME")
    private String name;
    
    //人数
    @Column(name = "C_NUMBER")
    private Integer number;
    
    public Clazz() {
        super();
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getNumber() {
        return number;
    }
    
    public void setNumber(Integer number) {
        this.number = number;
    }
    
}
