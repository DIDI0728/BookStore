package com.zyl.bookstore.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@TableName("bookadmin")
public class Bookadmin {
    int id;
    String username;
    String password;

    public Bookadmin() {
    }

    public Bookadmin(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
