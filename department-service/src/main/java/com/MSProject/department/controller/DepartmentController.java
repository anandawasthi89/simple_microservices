package com.MSProject.department.controller;

import com.MSProject.department.entities.Department;
import com.MSProject.department.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(path = "/")
    public Department addDepartment(@RequestBody Department department){

        Department dres= departmentService.addDepartment(department);
        log.info("department add: "+dres);
        return dres;
    }

    @GetMapping(path = "/{DepartmentId}")
    public Department getDepartmentByDepartmentId(@PathVariable Long DepartmentId){

        log.info("Inside department Controller getDepartmentByDepartmentId");
        return departmentService.getDepartmentByDepartmentId(DepartmentId);
    }


}
