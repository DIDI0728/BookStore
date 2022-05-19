package com.zyl.bookstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyl.bookstore.dao.BookInfoDao;
import com.zyl.bookstore.pojo.BookInfo;
import com.zyl.bookstore.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoServiceImpl extends ServiceImpl<BookInfoDao, BookInfo> implements BookInfoService {
    @Autowired
    BookInfoDao bookInfoDao;

    public List<BookInfo> getAll(int borrowerId){
        List<BookInfo> bookInfos = bookInfoDao.getAll(borrowerId);
        return bookInfos;
    }

}
