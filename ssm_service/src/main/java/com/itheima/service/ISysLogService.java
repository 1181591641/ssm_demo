package com.itheima.service;

import com.itheima.domain.SysLog;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/11/5 11:23
 * @Version 1.0
 */
public interface ISysLogService {
public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(Integer page, Integer size) throws Exception;
}


