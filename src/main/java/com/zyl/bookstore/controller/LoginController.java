package com.zyl.bookstore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyl.bookstore.pojo.Bookadmin;
import com.zyl.bookstore.pojo.Borrower;
import com.zyl.bookstore.pojo.Sysadmin;
import com.zyl.bookstore.service.BookadminService;
import com.zyl.bookstore.service.BorrowerService;
import com.zyl.bookstore.service.SysadminService;
import com.zyl.bookstore.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private SysadminService sysadminService;

    @Autowired
    private BookadminService bookadminService;

    @Autowired
    private BorrowerService borrowerService;

    @RequestMapping("/{type}/{username}/{password}")
    public R login(@PathVariable("type") String type,@PathVariable("username") String username,@PathVariable("password") String password){
        boolean flag=false;
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        if(type.equals("sysadmin")){
            //系统管理员登录
            Sysadmin one = sysadminService.getOne(queryWrapper);
            if(one!=null)
                flag=true;
            else flag=false;


        }else if(type.equals("bookadmin")){
            //图书管理员登录
            Bookadmin one = bookadminService.getOne(queryWrapper);
            if(one!=null)
                flag=true;
            else flag=false;

        }else {
            //借阅者登录
            Borrower one = borrowerService.getOne(queryWrapper);
            if(one!=null)
                flag=true;
            else flag=false;
        }
        return new R(flag,flag?"登录成功!":"登录失败！");
    }
}
