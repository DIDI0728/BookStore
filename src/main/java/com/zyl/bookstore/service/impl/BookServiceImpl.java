package com.zyl.bookstore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyl.bookstore.dao.BookDao;
import com.zyl.bookstore.pojo.Book;
import com.zyl.bookstore.pojo.LendList;
import com.zyl.bookstore.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public IPage<Book> getPage(int current, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getBookName()),Book::getBookName,book.getBookName());
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getIsbn()),Book::getIsbn,book.getIsbn());

        Page<Book> bookPage = new Page<>(current, pageSize);
        Page<Book> page = bookDao.selectPage(bookPage, lqw);
        return page;
    }

    @Override
    public List<LendList> getLendlist(int borrowerId) {
        List<LendList> lendlist = bookDao.getLendlist(borrowerId);
        return lendlist;
    }

    @Override
    public boolean updateNum(int bookId) {

        boolean flag = bookDao.updateNum(bookId);
        return flag;


    }

    @Override
    public boolean Outbook(String bookName, int num,String isbn) {
        boolean flag = bookDao.Outbook(bookName, num,isbn);
        return flag;
    }

    @Override
    public boolean backBook(int id) {
        boolean flag = bookDao.backBook(id);
        return flag;
    }

    @Override
    public List<Book> getLessBook() {
        List<Book> bookList = bookDao.getLessBook();
        return bookList;
    }


}
