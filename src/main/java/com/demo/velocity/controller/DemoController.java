package com.demo.velocity.controller;

import com.demo.velocity.dto.RequestDTO;
import com.demo.velocity.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping("/executor")
    public void getDemoService(@RequestBody RequestDTO requestDTO) {
        demoService.executor(requestDTO);
    }
}
