package com.MSProject.department.services;

import com.MSProject.department.entities.Department;
import com.MSProject.department.repositories.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) {

        log.info("Inside department service addDepartment");
        return departmentRepository.save(department);
    }

    public Department getDepartmentByDepartmentId(Long DepartmentId) {

        log.info("Inside department service getDepartmentByDepartmentId");
        return departmentRepository.findByDepartmentId(DepartmentId);
    }
}
