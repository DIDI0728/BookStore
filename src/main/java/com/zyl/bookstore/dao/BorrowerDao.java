package com.zyl.bookstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyl.bookstore.pojo.Borrower;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BorrowerDao extends BaseMapper<Borrower> {
}
