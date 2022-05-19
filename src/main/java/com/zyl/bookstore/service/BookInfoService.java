package com.zyl.bookstore.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyl.bookstore.pojo.BookInfo;

import java.util.List;

public interface BookInfoService extends IService<BookInfo> {
    public List<BookInfo> getAll(int borrowerId);

}
