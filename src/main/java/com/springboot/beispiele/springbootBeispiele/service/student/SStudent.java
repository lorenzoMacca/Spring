package com.springboot.beispiele.springbootBeispiele.service.student;

import com.springboot.beispiele.springbootBeispiele.entities.EStudent;
import com.springboot.beispiele.springbootBeispiele.intermediate.IQuery;
import com.springboot.beispiele.springbootBeispiele.service.common.CommonService;

public class SStudent extends CommonService<EStudent, Long>{

    public SStudent(IQuery<EStudent, Long> query) {
        super(query);
    }
}
