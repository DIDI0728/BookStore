package com.zyl.bookstore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyl.bookstore.pojo.LendList;
import com.zyl.bookstore.service.BookService;
import com.zyl.bookstore.service.LendListService;
import com.zyl.bookstore.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/lendlist")
public class LendListController {
    @Autowired
    BookService bookService;
    @Autowired
    LendListService lendListService;

    @GetMapping("/{borrowerId}")
    public List<LendList> getLendlist(@PathVariable("borrowerId") int borrowerId){
        List<LendList> lendlist = bookService.getLendlist(borrowerId);
        return lendlist;
    }

    @PostMapping("/add")
    public R addLendlist(@RequestBody com.zyl.bookstore.pojo.LendList lendList){
        boolean flag = lendListService.save(lendList);
        return new R(flag,flag?"借阅成功":"借阅失败");
    }

    @PutMapping("/delete/{id}")
    public  R deleteLendlistById(@PathVariable int id){
        boolean flag = lendListService.removeById(id);

        return new R(flag,flag?"删除成功！":"删除失败!");

    }


    @PostMapping("/updata")
    public R updataById(@RequestBody LendList lendList){
        boolean flag = lendListService.updateById(lendList);
        return new R(flag,flag?"续借成功！":"续借失败！");
    }

    @PutMapping("/ifExist/{borrowerId}/{bookId}")
    public R ifExist(@PathVariable("borrowerId") int borrowerId, @PathVariable("bookId") int bookId){
        boolean flag=false;
        QueryWrapper<LendList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("borrower_id",borrowerId);
        queryWrapper.eq("book_id",bookId);
        LendList lendList = lendListService.getOne(queryWrapper);
        if(lendList!=null)
            flag=true;
        return new R(flag,flag?"您已借阅过本书，请勿重复借阅！":"该书还未借阅");

    }

    @PutMapping("/getOver")
    public R getOverDueLendList() throws ParseException {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = simpleDateFormat.format(date);

        Date currentTime = simpleDateFormat.parse(currentDate);
        long currentTimeTime = currentTime.getTime();

        List<LendList> lists = lendListService.getOver(currentDate);
        for (LendList list : lists) {
            Date backTime = simpleDateFormat.parse(list.getBackDate());
            long backTimeTime = backTime.getTime();
            long time=currentTimeTime-backTimeTime;
            int days=(int)time/(24*60*60*1000);
            list.setDays(days);
        }

        return new R(true,lists, "获取数据成功！");
    }

}
