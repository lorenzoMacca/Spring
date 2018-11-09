package com.training.controller;

import com.training.entities.EStudent;
import com.training.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CStudent {

    @Autowired
    private CommonService<EStudent, Long> commonService;

    public CStudent(CommonService<EStudent, Long> commonService) {
        this.commonService=commonService;
    }

    @GetMapping(name = "/students")
    public Iterable<EStudent> getAllStudents(){
        return commonService.getAll();
    }


}
