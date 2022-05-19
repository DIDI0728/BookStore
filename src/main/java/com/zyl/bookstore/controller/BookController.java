package com.zyl.bookstore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyl.bookstore.pojo.Book;
import com.zyl.bookstore.service.BookService;
import com.zyl.bookstore.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/getAll")
    public List<Book> selectAll(){
        List<Book> bookList = bookService.list();
        return bookList;
    }

    @PostMapping("/add")
    public R addBook(@RequestBody Book book){
        boolean flag = bookService.save(book);
        return new R(flag,"添加成功");
    }

    @GetMapping("/{current}/{pagesize}")
    public R getPage(@PathVariable("current") int current,@PathVariable("pagesize") int pagesize,Book book){

        IPage<Book> page = bookService.getPage(current, pagesize, book);

        if(current>page.getPages()){
            page=bookService.getPage((int)page.getPages(),pagesize,book);
        }
        return new R(true,page);
    }

    @GetMapping("/{id}")
    public R selectById(@PathVariable("id") int id){
        Book book = bookService.getById(id);
        return new R(true,book);
    }

    @PutMapping
    public R updata(@RequestBody Book book){
        boolean flag = bookService.updateById(book);
        return new R(flag,flag?"修改成功！":"修改失败！");
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable("id") int id){
        boolean flag = bookService.removeById(id);
        return new R(flag,flag?"删除成功!":"删除失败!");
    }


    @GetMapping("/ifempty/{id}")
    public R ifEmpty(@PathVariable("id") int id){
        boolean flag=false;
        Book book = bookService.getById(id);
        if(book.getNum()>0)
            flag=true;
        return new R(flag,flag?"notNull":"isNull");
    }



    //借书
    @PutMapping("/upNum")
    public R upNum(@RequestBody Book book){
        //库存数量-1
        boolean flag = bookService.updateNum(book.getBookId());

        return new R(flag,flag?"upNumSuccess":"upNumFail");
    }

    @PutMapping("/outBook/{bookName}/{num}/{isbn}")
    public R OutBook(@PathVariable("bookName") String bookName,@PathVariable("num") int num,@PathVariable("isbn") String isbn){
        boolean flag = bookService.Outbook(bookName, num,isbn);
        return new R(flag,flag?"出库成功!":"出库失败！");
    }

    @PutMapping("/backbook/{id}")
    public R BackBook(@PathVariable("id") int id){

        boolean flag = bookService.backBook(id);

        return new R(true,flag?"归还成功！":"归还失败");
    }


    @PutMapping("/getLessBook")
    public R getLessBook(){
        List<Book> bookList = bookService.getLessBook();
        return new R(true,bookList);
    }
}
