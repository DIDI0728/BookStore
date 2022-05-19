package com.zyl.bookstore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyl.bookstore.dao.BookadminDao;
import com.zyl.bookstore.pojo.Bookadmin;
import com.zyl.bookstore.service.BookadminService;
import org.springframework.stereotype.Service;

@Service
public class BookadminServiceImpl extends ServiceImpl<BookadminDao,Bookadmin> implements BookadminService {
}
