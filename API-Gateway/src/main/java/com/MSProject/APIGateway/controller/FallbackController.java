package com.MSProject.APIGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Fallback")
public class FallbackController {

    @GetMapping(path = "/department")
    public String DepartmentFallback(){

        return "Fallback method for department service";
    }

    @GetMapping(path = "/user")
    public String UserFallback(){

        return "Fallback method for user service";
    }

}
