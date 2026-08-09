package com.coder.emp_mngt.controller;

import com.coder.emp_mngt.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping() // use /api/v1
public class HomeController {

    @Autowired
    HomeService service;

    @GetMapping("/home")
    public String description() {
        return service.description();
    }

    @GetMapping("/vision")
    public String vision() {
        return service.vision();
    }

    @GetMapping("/about")
    public String about() {
        return service.about();
    }
}
