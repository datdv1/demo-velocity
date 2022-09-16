package com.demo.velocity.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.generic.MathTool;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Properties;

@Slf4j
@Configurable
public class VelocityConfigs {

    @Bean("demoVelocityEngine")
    public VelocityEngine getVelocityEngine() {

        VelocityEngine ve = new VelocityEngine();

        Properties p = new Properties();
        p.put("velocimacro.permissions.allow.inline.local.scope", "true");
        p.put("velocimacro.library.autoreload", "true");
        p.put("velocimacro.context.localscope", "true");
        ve.setProperty("runtime.log.logsystem.log4j.logger", "root");

        ve.init(p);
        return ve;
    }

    @Bean("demoVelocityContext")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public VelocityContext getVelocityContext() {

        VelocityContext vc = new VelocityContext();
        vc.put("math", new MathTool());

        return vc;

    }
}