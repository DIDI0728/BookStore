package com.zyl.bookstore.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@TableName("lend_list")
public class LendList {


    @TableField(exist = false)
    String bookName;
    @TableField(exist = false)
    String author;
    @TableField(exist = false)
    String publishingHouse;
    @TableField(exist = false)
    String borrowerName;
    @TableField(exist = false)
    int days;

    @TableId("ser_num")
    int serNum;
    String bookId;
    String borrowerId;
    String lendDate;
    String backDate;

    public LendList() {
    }

    public LendList(String bookName, String author, String publishingHouse, String borrowerName, int days, int serNum, String bookId, String borrowerId, String lendDate, String backDate) {
        this.bookName = bookName;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.borrowerName = borrowerName;
        this.days = days;
        this.serNum = serNum;
        this.bookId = bookId;
        this.borrowerId = borrowerId;
        this.lendDate = lendDate;
        this.backDate = backDate;
    }
}
