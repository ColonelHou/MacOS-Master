package org.macos.java.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by colonelhou on 2019/5/6.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
        return "Hello + World ";
    }
}
