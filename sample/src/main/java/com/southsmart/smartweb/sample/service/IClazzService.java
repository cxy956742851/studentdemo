package com.southsmart.smartweb.sample.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.southsmart.smartweb.sample.entity.Clazz;

public interface IClazzService {
    /**
     * Spring注册时的名称.
     */
    public static final String SERVICE_BEAN_NAME = "clazzService";
    
    Clazz getClassById(String classId);
    
    Page<Clazz> getClassByPage();
    
    List<Clazz> getClazzList();
    
    List<Clazz> getClazzByName(String name);
    
    Clazz saveClazz(Clazz entity);
    
    void deleteClazzById(String id);
    
    boolean checkExists(String id);
    
    Long getCount();
    
    List<Clazz> getClazzListBySort();
    
    void updateClazz(Clazz entity);
    
    List<Clazz> findByNameUseSql(String name);
    
    Page<Clazz> findAllByNativeSql();
    
}
