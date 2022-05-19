package com.zyl.bookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyl.bookstore.pojo.LendList;

import java.util.List;

public interface LendListService extends IService<LendList> {


    public List<LendList> getOver(String backDate);
}
