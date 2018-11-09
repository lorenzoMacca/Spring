package com.training.controller.training.swim;

import com.training.service.training.swim.ISwimService;
import com.training.service.training.swim.ISwimminPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwimController {

    @Autowired
    ISwimService swimService;

    @Autowired
    ISwimminPoolService swimminPoolService;
}
