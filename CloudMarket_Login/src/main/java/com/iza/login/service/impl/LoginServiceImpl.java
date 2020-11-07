package com.iza.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iza.common.config.RedisKeyConfig;
import com.iza.common.config.UserStatus;
import com.iza.common.dto.UserDto;
import com.iza.common.vo.R;
import com.iza.entity.User;
import com.iza.login.dao.LoginDao;
import com.iza.login.service.intf.LoginService;
import com.iza.login.third.RedissonUtil;
import com.iza.login.util.EncryptUtil;
import com.iza.login.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/5 19:21
 * description:
 */

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao dao;
    @Override
    public R login(UserDto dto) {
        //判断对象非空
        if (dto != null) {
            //判断对象内属性是否满足要求
            if (dto.getAccount()!= null && dto.getPasword()!=null) {
                //更据账号查找用户
                QueryWrapper<User> wrapper = new QueryWrapper<>();
                wrapper.eq("account",dto.getAccount());
                User user = dao.selectOne(wrapper);
                if (user == null) {
                    return R.fail("用户未注册");
                }
                if (!user.getPassword().equals(EncryptUtil.sha(EncryptUtil.SHA256,dto.getPasword()))) {
                    return R.fail("用户密码不正确");
                }
                //用户账号密码正确
                //生成token    用户账号
                String token = JwtUtil.createToken(dto.getAccount());
                //查看redis服务器是否存在
                String str = RedissonUtil.getStr(token);
                //用户刚登录
                if (str != null) {
                    //重置token有效期
                    RedissonUtil.setTime(token,RedisKeyConfig.TOKEN_TIME, TimeUnit.SECONDS);
                }else{
                    //未登录过
                    //将token存放在redis服务器
                    RedissonUtil.setStr(token, "已登录", RedisKeyConfig.TOKEN_TIME);
                }

               //将token返回
                return R.ok(token);

            }
        }
        return R.fail();
    }
}
