package com.zyl.bookstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyl.bookstore.pojo.Book;
import com.zyl.bookstore.pojo.LendList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookDao extends BaseMapper<Book> {

    @Select("select bookstore.books.*, ll.* from bookstore.lend_list ll ,bookstore.books books where ll.borrower_id=#{borrowerId} and ll.book_id=books.book_id")
    public List<LendList> getLendlist(int borrowerId);

    @Update("update bookstore.books set num=num-1 where book_id=#{bookId}")
    public boolean updateNum(int bookId);

    @Update("update bookstore.books set num=num-#{num} where book_name=#{bookName} and isbn=#{isbn}")
    public boolean Outbook(@Param("bookName") String bookName,@Param("num") int num,@Param("isbn") String isbn);

    @Update("update bookstore.books set num=num+1 where book_id=#{id}")
    public boolean backBook(@Param(("id")) int id);

    @Select("select * from bookstore.books where num<=5")
    public List<Book> getLessBook();

}
