package com.zyl.bookstore.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("books")
public class Book {
    @TableId
    int bookId;
    String isbn;
    String bookName;
    String author;
    String type;
    String publishingHouse;
    String publicationDate;
    String brief;
    String remark;
    int num;


    public Book() {
    }

    public Book(int bookId, String isbn, String bookName, String author, String type, String publishingHouse, String publicationDate, String brief, String remark, int num) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.type = type;
        this.publishingHouse = publishingHouse;
        this.publicationDate = publicationDate;
        this.brief = brief;
        this.remark = remark;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", brief='" + brief + '\'' +
                ", remark='" + remark + '\'' +
                ", num=" + num +
                '}';
    }
}
