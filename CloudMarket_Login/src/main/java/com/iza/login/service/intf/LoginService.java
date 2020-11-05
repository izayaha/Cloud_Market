package com.iza.login.service.intf;

import com.iza.common.dto.UserDto;
import com.iza.common.vo.R;

public interface LoginService {
    R login(UserDto dto);

}
