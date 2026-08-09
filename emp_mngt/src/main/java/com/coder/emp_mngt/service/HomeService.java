package com.coder.emp_mngt.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public String vision;

    public String description() {
        String describe = "Employee Management System" +
                "A simple and secure platform to manage employee information, " +
                "departments, designations, and records efficiently—all in one place.";
        return describe;
    }

    public String vision() {
        String view = "Our Vision" +
                "To simplify employee management through technology and help organizations " +
                "become more efficient, organized, and productive.";
        return view;
    }

    public String about() {
        String about = "About Us"+
                "Employee Management System is a modern solution designed to make employee data " +
                "management simple, secure, and efficient." +
                "Co-Founder: Suraj";
        return about;
    }
}
