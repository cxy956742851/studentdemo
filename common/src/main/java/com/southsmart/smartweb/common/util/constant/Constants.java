package com.southsmart.smartweb.common.util.constant;

/**
 * 常量
 */
public class Constants {
    
    public static final Integer RESULT_STATUS_SUCCESS = 0; //返回状态 成功
    
    public static final Integer RESULT_STATUS_FAIL = 1; //返回状态 失败
    
    public static final Integer RESULT_STATUS_ERROR = 2; //返回状态 程序出错
    
    //返回说明
    public static final String RESULT_MESSAGE_SUCCESS = "操作成功！";
    
    public static final String RESULT_MESSAGE_FAIL = "操作失败！";
    
    public static final String RESULT_MESSAGE_ERROR = "程序出错！";
    
    /**
     * websocket 连接标识: ?flag=cpuratio
     */
    public static final String WebSocket_Flag = "flag";
    
    public static final String WebSocket_CpuRatio = "cpuratio"; //cpu 使用率
    
    public static final String WebSocket_MemRatio = "memratio"; //内存 使用率
    
    public static final String WebSocket_MemInfo = "meminfo"; //内存信息
    
    public static final String WebSocket_DiskInfo = "diskinfo"; //磁盘信息
    
    public static final String WebSocket_NetInfo = "netinfo"; //网络信息
    
}
