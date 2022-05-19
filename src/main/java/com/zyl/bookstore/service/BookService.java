package com.zyl.bookstore.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyl.bookstore.pojo.Book;
import com.zyl.bookstore.pojo.LendList;


import java.util.List;

public interface BookService extends IService<Book> {
    IPage<Book> getPage(int current,int pageSize,Book book);

    public List<LendList> getLendlist(int borrowerId);

    public boolean updateNum(int bookId);

    public boolean Outbook(String bookName,int num,String isbn);


    public boolean backBook(int id);


    public List<Book> getLessBook();
}
