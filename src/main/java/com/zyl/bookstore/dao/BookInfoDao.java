package com.zyl.bookstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyl.bookstore.pojo.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookInfoDao extends BaseMapper<BookInfo> {

    @Select("select bookstore.bookinfo.*,bookstore.books.num from bookstore.bookinfo,bookstore.books where bookstore.bookinfo.book_name=bookstore.books.book_name and bookstore.bookinfo.borrower_id=#{borrowerId}")
    public List<BookInfo> getAll(int borrowerId);
}
