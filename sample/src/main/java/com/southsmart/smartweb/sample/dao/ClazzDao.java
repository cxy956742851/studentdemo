package com.southsmart.smartweb.sample.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.southsmart.smartweb.sample.entity.Clazz;

/**
 * Repository 类，JpaRepository 继承了PagingAndSortingRepository 和CrudRepository
 * 有默认的实现方式可以使用。先查看一下接口中的默认实现。 然后看一下这个帖子，看一下怎么通过方法名来完成具体的查询
 * https://www.cnblogs.com/toSeeMyDream/p/6170790.html
 * 
 * @Title:
 * @Description:
 * @Author:Administrator
 * @Since:2018年8月20日
 * @Version:1.1.0
 */
@Repository(ClazzDao.DAO_BEAN_NAME)
public interface ClazzDao extends JpaRepository<Clazz, String> {
    /**
     * Spring注册时的名称.
     */
    public static final String DAO_BEAN_NAME = "classDao";
    
    /**
     * 方法名查询
     * 
     * @param name
     * @return
     * @Description:
     */
    public List<Clazz> findByName(String name);
    
    /**
     * Query注解的使用，按名称填充
     * 
     * @param name
     * @param id
     * @Description:
     */
    @Modifying
    @Query("update Clazz c set c.name = :name where c.id = :id")
    public void updateOneByParam(@Param("id") String id, @Param("name") String name);
    
    /**
     * Query注解的使用，按位置填充
     * 
     * @param name
     * @param id
     * @Description:
     */
    @Query("update Clazz c set c.name = ?1 where c.id =?2")
    @Modifying
    public void updateOneByPlaceholder(String name, String id);
    
    /**
     * 利用sql查询，需要指定nativeQuery=true
     * 
     * @param name
     * @return
     * @Description:
     */
    @Query(value = "select t.* from demo_class t where t.c_name like %?1% ", nativeQuery = true)
    public List<Clazz> findByNameUseSql(String name);
    
    /**
     * 直接执行sql查询，需要配置countQuery
     * 
     * @param pageable
     * @return
     * @Description:
     */
    @Query(value = "select * from demo_class  ", countQuery = "select count(*) from demo_class", nativeQuery = true)
    Page<Clazz> findAllByNativeSql(Pageable pageable);
    
    /*@Query(value = "select * from demo_class   ORDER BY ?#{#pageable}", 
        countQuery = "select count(*) from demo_class ", nativeQuery = true)
    Page<Clazz> findAllByNativeSql1(Pageable pageable);*/
    
}
