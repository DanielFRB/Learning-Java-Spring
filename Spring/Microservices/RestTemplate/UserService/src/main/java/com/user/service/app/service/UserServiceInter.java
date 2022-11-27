package com.user.service.app.service;

import com.user.service.app.dto.ResponseDto;
import com.user.service.app.model.User;

/**
 * @author danfe
 */

public interface UserServiceInter {
    User saveUser(User u);

    ResponseDto getUser(Long userId);
}
