package com.demo.velocity;

import com.demo.velocity.config.VelocityConfigs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = { VelocityConfigs.class})
public class DemoVelocityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoVelocityApplication.class, args);
    }

}
