package com.zyl.bookstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyl.bookstore.pojo.Sysadmin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysadminDao extends BaseMapper<Sysadmin> {
}
