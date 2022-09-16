package com.demo.velocity.service;

import com.demo.velocity.dto.RequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.StringWriter;

@Service
@Slf4j
public class DemoService {

    @Autowired
    @Qualifier(value = "demoVelocityEngine")
    private VelocityEngine velocityEngine;

    @Autowired
    private ApplicationContext ctx;

    public void executor(RequestDTO requestDTO) {
        StringWriter sw = new StringWriter();

        velocityEngine.evaluate(buildVelocityContext(requestDTO.getA(), requestDTO.getB()), sw, "DemoService", requestDTO.getTemplate());

        log.info("result: {}", sw);
    }

    private VelocityContext buildVelocityContext(Integer a, Integer b) {

        VelocityContext vc = (VelocityContext) ctx.getBean("demoVelocityContext");

        vc.put("a", a);
        vc.put("b", b);

        return vc;
    }
}
