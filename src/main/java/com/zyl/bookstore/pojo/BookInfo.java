package com.zyl.bookstore.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("bookinfo")
public class BookInfo {
    @TableId("book_server_id")
    int bookServerId;
    int borrowerId;

    @TableField(exist = false)
    int num;
    String bookName;
    String author;
    String publishingHouse;
    String bookDate;
    String status;
    int bookId;
}
