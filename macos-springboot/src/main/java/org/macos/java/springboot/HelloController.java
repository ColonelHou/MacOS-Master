package org.macos.java.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by colonelhou on 2019/5/6.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String hello(@RequestParam String title) {
        System.out.println("say ------> hello world" + title);
        return "Hello + World " + title;
    }

    @RequestMapping(name = "/haha")
    public long say(@RequestParam String abc) {
        System.out.println("say =======> 1000" + abc);
        return 1000;
    }
}
