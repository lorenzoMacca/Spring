package com.springboot.beispiele.springbootBeispiele.controller;

import com.springboot.beispiele.springbootBeispiele.entities.EStudent;
import com.springboot.beispiele.springbootBeispiele.service.common.student.SStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CStudent {

    @Autowired
    private SStudent commonService;

    @GetMapping(name = "students")
    public Iterable<EStudent> getAllStudents(){
        return commonService.getAll();
    }
}
