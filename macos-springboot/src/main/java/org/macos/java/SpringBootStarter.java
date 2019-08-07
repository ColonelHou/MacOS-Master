package org.macos.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by colonelhou on 2019/5/6.
 */
//@EnableAutoConfiguration
//@Controller
@SpringBootApplication
@EnableScheduling
@EnableCaching
@EnableSwagger2
public class SpringBootStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }
}
