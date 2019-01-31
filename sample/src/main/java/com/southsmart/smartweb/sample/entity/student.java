package com.southsmart.smartweb.sample.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 陈星宇 on 2019/1/30 17:27
 */

@Entity
@Table(name = "DEMO_STUDENT")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class student {
}
