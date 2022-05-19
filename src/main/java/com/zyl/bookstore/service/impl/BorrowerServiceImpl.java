package com.zyl.bookstore.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyl.bookstore.dao.BorrowerDao;
import com.zyl.bookstore.pojo.Borrower;
import com.zyl.bookstore.service.BorrowerService;
import org.springframework.stereotype.Service;

@Service
public class BorrowerServiceImpl extends ServiceImpl<BorrowerDao, Borrower> implements BorrowerService {
}
