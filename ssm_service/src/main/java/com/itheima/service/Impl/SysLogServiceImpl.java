package com.itheima.service.Impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.ISysLogDao;
import com.itheima.domain.SysLog;
import com.itheima.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: XXX
 * @Date: 2018/11/5 11:23
 * @Version 1.0
 */
@Service
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao dao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        dao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return dao.fundAll();
    }
}
