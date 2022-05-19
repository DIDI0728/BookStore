package com.zyl.bookstore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyl.bookstore.dao.SysadminDao;
import com.zyl.bookstore.pojo.Sysadmin;
import com.zyl.bookstore.service.SysadminService;
import org.springframework.stereotype.Service;

@Service
public class SysadminServiceImpl extends ServiceImpl<SysadminDao, Sysadmin> implements SysadminService {
}
