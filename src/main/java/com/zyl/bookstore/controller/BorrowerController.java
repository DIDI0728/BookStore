package com.zyl.bookstore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyl.bookstore.pojo.Borrower;
import com.zyl.bookstore.service.BorrowerService;
import com.zyl.bookstore.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrower")
public class BorrowerController {
    @Autowired
    BorrowerService borrowerService;

    @PostMapping
    public R getBorrower(@RequestBody Borrower borrower){

        QueryWrapper<Borrower> borrowerQueryWrapper = new QueryWrapper<>();
        borrowerQueryWrapper.eq("username",borrower.getUsername());
        Borrower borrower1 = borrowerService.getOne(borrowerQueryWrapper);
        return new R(true,borrower1);
    }


    @PostMapping("/add")
    public R addBorrower(@RequestBody Borrower borrower){
        boolean flag = borrowerService.save(borrower);

        return new R(flag,flag?"创建成功！":"创建失败！");
    }
}
