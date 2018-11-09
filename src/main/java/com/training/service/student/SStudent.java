package com.training.service.student;

import com.training.entities.EStudent;
import com.training.intermediate.IQuery;
import com.training.service.common.CommonService;

public class SStudent extends CommonService<EStudent, Long>{

    public SStudent(IQuery<EStudent, Long> query) {
        super(query);
    }
}
