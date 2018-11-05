package com.itheima.dao;

import com.itheima.domain.SysLog;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/11/5 11:25
 * @Version 1.0
 */
public interface ISysLogDao {
    public void save(SysLog sysLog) throws Exception;

    List<SysLog> fundAll() throws Exception;
}
