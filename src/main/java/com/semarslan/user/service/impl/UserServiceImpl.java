package com.semarslan.user.service.impl;

import com.semarslan.user.entity.User;
import com.semarslan.user.repository.UserRepository;
import com.semarslan.user.service.UserService;
import com.semarslan.user.valueObject.Department;
import com.semarslan.user.valueObject.ResponseTemplateVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");

        return userRepository.save(user);
    }

    @Override
    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");

        ResponseTemplateVO vo = new ResponseTemplateVO();

        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
