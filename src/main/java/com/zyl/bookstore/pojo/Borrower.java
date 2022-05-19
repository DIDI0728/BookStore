package com.zyl.bookstore.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("borrower")
public class Borrower {
    @TableId("borrower_id")
    int id;
    String username;
    String password;
    @TableField("borrower_name")
    String name;
    String academy;
    String classname;
    String phone;
}
