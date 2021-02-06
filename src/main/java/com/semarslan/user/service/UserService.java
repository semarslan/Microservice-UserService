package com.semarslan.user.service;

import com.semarslan.user.entity.User;
import com.semarslan.user.valueObject.ResponseTemplateVO;

public interface UserService {
    User saveUser(User user);

    ResponseTemplateVO getUserWithDepartment(Long userId);
}
