package com.iza.login.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iza.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao extends BaseMapper<User> {

}
