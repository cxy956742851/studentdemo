package com.southsmart.smartweb.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.southsmart.smartweb.sample.dao.ClazzDao;
import com.southsmart.smartweb.sample.entity.Clazz;
import com.southsmart.smartweb.sample.service.IClazzService;

@Service(IClazzService.SERVICE_BEAN_NAME)
public class ClazzServiceImpl implements IClazzService {
    
    @Resource(name = ClazzDao.DAO_BEAN_NAME)
    private ClazzDao calzzRepository;
    
    @Override
    public Clazz getClassById(String classId) {
        return calzzRepository.getOne(classId);
    }
    
    @Override
    public Page<Clazz> getClassByPage() {
        int page = 0;
        int size = 15;
        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return calzzRepository.findAll(pageable);
    }
    
    @Override
    public List<Clazz> getClazzList() {
        return calzzRepository.findAll();
    }
    
    @Override
    public List<Clazz> getClazzListBySort() {
        Sort sort = new Sort(Direction.DESC, "id");
        return calzzRepository.findAll(sort);
    }
    
    @Override
    public List<Clazz> getClazzByName(String name) {
        return calzzRepository.findByName(name);
    }
    
    @Override
    public Clazz saveClazz(Clazz entity) {
        return calzzRepository.save(entity);
    }
    
    @Override
    public void deleteClazzById(String id) {
        calzzRepository.deleteById(id);
    }
    
    @Override
    public boolean checkExists(String id) {
        return calzzRepository.existsById(id);
    }
    
    @Override
    public Long getCount() {
        return calzzRepository.count();
    }
    
    @Override
    @Transactional(readOnly = false)
    public void updateClazz(Clazz entity) {
        String name = entity.getName();
        String id = entity.getId();
        //        calzzRepository.updateOneByParam(id,name);
        calzzRepository.updateOneByPlaceholder(name, id);
    }
    
    @Override
    public List<Clazz> findByNameUseSql(String name) {
        return calzzRepository.findByNameUseSql(name);
    }
    
    @Override
    public Page<Clazz> findAllByNativeSql() {
        int iPage = 0;
        int iSize = 15;
        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = PageRequest.of(iPage, iSize, sort);
        Page<Clazz> page = calzzRepository.findAllByNativeSql(pageable);
        return page;
    }
    
}
