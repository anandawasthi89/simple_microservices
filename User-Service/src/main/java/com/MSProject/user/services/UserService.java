package com.MSProject.user.services;

import com.MSProject.user.entities.Department;
import com.MSProject.user.entities.ResponseObject;
import com.MSProject.user.entities.User;
import com.MSProject.user.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User addUser(User user) {

        log.info("inside UserService addUser method");
        return userRepository.save(user);
    }

    public ResponseObject getUserByIdWithItsDepartment(Long userId){

        ResponseObject ro=new ResponseObject();
        User user=userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://department-service/Departments/"+user.getDepartmentId(), Department.class);

        ro.setUser(user);
        ro.setDepartment(department);

        return ro;
    }

}
