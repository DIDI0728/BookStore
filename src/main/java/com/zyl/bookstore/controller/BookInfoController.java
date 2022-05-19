package com.zyl.bookstore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyl.bookstore.pojo.BookInfo;
import com.zyl.bookstore.pojo.LendList;
import com.zyl.bookstore.service.BookInfoService;
import com.zyl.bookstore.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookInfo")
public class BookInfoController {
    @Autowired
    BookInfoService bookInfoService;

    @PostMapping("/add")
    public R addBookInfo(@RequestBody BookInfo bookInfo){
        boolean flag = bookInfoService.save(bookInfo);
        return new R(flag,flag?"预订成功！":"预订失败!");
    }


    @GetMapping("/getAll/{borrowerId}")
    public R getByBorrowerId(@PathVariable int borrowerId){
        List<BookInfo> bookInfos = bookInfoService.getAll(borrowerId);
        boolean flag= bookInfos != null;
        return new R(flag,bookInfos);
    }

    @PostMapping("/delete")
    public R delete(@RequestBody BookInfo bookInfo){
        boolean flag = bookInfoService.removeById(bookInfo.getBookServerId());
        return new R(flag,flag?"取消预约成功！":"取消失败！");
    }

    @PutMapping("/ifExist/{borrowerId}/{bookId}")
    public R ifExist(@PathVariable("borrowerId") int borrowerId,@PathVariable("bookId") int bookId){
        QueryWrapper<BookInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("borrower_id",borrowerId);
        queryWrapper.eq("book_id",bookId);
        boolean flag=false;
        BookInfo bookInfo = bookInfoService.getOne(queryWrapper);
        if(bookInfo!=null)
            flag=true;
        return new R(flag,flag?"您已预订过该书，请勿重复预订！":"该书还未预订");
    }


}
