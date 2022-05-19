package com.zyl.bookstore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyl.bookstore.dao.LendListDao;
import com.zyl.bookstore.pojo.LendList;
import com.zyl.bookstore.service.LendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendListServiceImpl extends ServiceImpl<LendListDao, LendList> implements LendListService {
    @Autowired
    LendListDao lendListDao;

    public List<LendList> getOver(String backDate){
        List<LendList> lendLists = lendListDao.getOverTime(backDate);
        return lendLists;
    }

}
