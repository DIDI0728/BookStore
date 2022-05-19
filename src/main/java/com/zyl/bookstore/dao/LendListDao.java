package com.zyl.bookstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyl.bookstore.pojo.LendList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LendListDao extends BaseMapper<LendList> {

    @Select("select bookstore.books.book_name,bookstore.borrower.borrower_name,bookstore.lend_list.lend_date,bookstore.lend_list.back_date from bookstore.books , bookstore.borrower , bookstore.lend_list where bookstore.lend_list.back_date<#{backDate} and bookstore.books.book_id=bookstore.lend_list.book_id and bookstore.borrower.borrower_id=bookstore.lend_list.borrower_id ")
    public List<LendList> getOverTime(String backDate);
}
