package com.zyl.bookstore.utils;

import lombok.Data;

@Data
public class R {
    boolean flag;
    Object data;
    String msg;

    public R(boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public R(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}
