package org.macos.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by colonelhou on 2019/5/6.
 */
//@EnableAutoConfiguration
//@Controller
@SpringBootApplication
@EnableScheduling
@EnableCaching
public class SpringBootStarter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }
}
