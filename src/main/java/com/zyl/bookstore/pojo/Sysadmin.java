package com.zyl.bookstore.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sysadmin")
public class Sysadmin {
    @TableId
    int adminid;
    String username;
    String password;

    public Sysadmin() {
    }

    public Sysadmin(int adminid, String username, String password) {
        this.adminid = adminid;
        this.username = username;
        this.password = password;
    }
}
