package com.southsmart.smartweb.sample.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.southsmart.smartweb.common.model.Result;
import com.southsmart.smartweb.common.util.ResultUtil;
import com.southsmart.smartweb.sample.entity.Clazz;
import com.southsmart.smartweb.sample.service.IClazzService;

@Controller
@RequestMapping(value = "/clazz")
public class ClazzController {
    
    private static final Logger log = LoggerFactory.getLogger(ClazzController.class);
    
    @Resource(name = IClazzService.SERVICE_BEAN_NAME)
    private IClazzService clazzService;
    
    /**
     * 按id查询班级信息
     * 
     * @param classId
     * @return
     * @Description:
     */
    @RequestMapping(value = "/getClassById")
    @ResponseBody
    public Result getClassById(String classId) {
        return ResultUtil.success(clazzService.getClassById(classId));
    }
    
    /**
     * 分页查询班级信息
     * 
     * @return
     * @Description:
     */
    @RequestMapping(value = "/getClassByPage")
    @ResponseBody
    public Result getClassByPage() {
        return ResultUtil.success(clazzService.getClassByPage());
    }
    
    /**
     * 查询所有班级信息
     * 
     * @return
     * @Description:
     */
    @RequestMapping(value = "/getClazzList")
    @ResponseBody
    public Result getClazzList() {
        return ResultUtil.success(clazzService.getClazzList());
    }
    
    /**
     * 通过名称查询班级信息，非模糊
     * 
     * @param name
     * @return
     * @Description:
     */
    @RequestMapping(value = "/getClazzByName")
    @ResponseBody
    public Result getClazzByName(String name) {
        return ResultUtil.success(clazzService.getClazzByName(name));
    }
    
    /**
     * 保存班级信息
     * 
     * @param entity
     * @return
     * @Description:
     */
    @RequestMapping(value = "/saveClazz", method = RequestMethod.POST)
    @ResponseBody
    public Result saveClazz(@RequestBody Clazz entity) {
        return ResultUtil.success(clazzService.saveClazz(entity));
    }
    
    /**
     * 按id删除班级信息
     * 
     * @param id
     * @return
     * @Description:
     */
    @RequestMapping(value = "/deleteClazzById")
    @ResponseBody
    public Result deleteClazzById(String id) {
        clazzService.deleteClazzById(id);
        return ResultUtil.success();
    }
    
    /**
     * 查询所有班级信息，已排序
     * 
     * @return
     * @Description:
     */
    @RequestMapping(value = "/getClazzListBySort")
    @ResponseBody
    public Result getClazzListBySort() {
        return ResultUtil.success(clazzService.getClazzListBySort());
    }
    
    /**
     * 判定班级记录已经存在
     * 
     * @param id
     * @return
     * @Description:
     */
    @RequestMapping(value = "/checkExists")
    @ResponseBody
    public Result checkExists(String id) {
        return ResultUtil.success(clazzService.checkExists(id));
    }
    
    /**
     * 获取班级总数
     * 
     * @return
     * @Description:
     */
    @RequestMapping(value = "/getCount")
    @ResponseBody
    public Result getCount() {
        return ResultUtil.success(clazzService.getCount());
    }
    
    /**
     * 更新班级信息
     * 
     * @param entity
     * @return
     * @Description:
     */
    @RequestMapping(value = "/updateClazz")
    @ResponseBody
    public Result updateClazz(Clazz entity) {
        clazzService.updateClazz(entity);
        return ResultUtil.success();
    }
    
    /**
     * 通过sql来查询班级信息
     * 
     * @param name
     * @return
     * @Description:
     */
    @RequestMapping(value = "/findByNameUseSql")
    @ResponseBody
    public Result findByNameUseSql(String name) {
        return ResultUtil.success(clazzService.findByNameUseSql(name));
    }
    
    /**
     * 通过sql分页查询班级信息
     * 
     * @return
     * @Description:
     */
    @RequestMapping(value = "/findAllByNativeSql")
    @ResponseBody
    public Result findAllByNativeSql() {
        return ResultUtil.success(clazzService.findAllByNativeSql());
    }
    
    @RequestMapping(value = "/logTest")
    @ResponseBody
    public void logTest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info("纯字符串信息的info级别日志" + session.getId());
    }
    
    @RequestMapping(value = "/logTest1")
    @ResponseBody
    public void logTest1() {
        log.info("纯字符串信息的info级别日志");
    }
    
}
