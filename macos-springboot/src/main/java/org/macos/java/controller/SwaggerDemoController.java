package org.macos.java.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.macos.java.dao.beans.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
@Api("swaggerDemoController相关的api")
public class SwaggerDemoController {

    private static final Logger logger= LoggerFactory.getLogger(SwaggerDemoController.class);

    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable int id) {
        logger.info("开始查询某个学生信息");

        List<Student> list = new ArrayList<>();
        list.add(new Student(22, "tom", "bj"));
        list.add(new Student(23, "jim", "sh"));
        list.add(new Student(24, "lim", "gz"));
        list.add(new Student(25, "olm", "sz"));
        list.add(new Student(26, "hnm", "hz"));
        List<Student> back = list.stream().filter(s -> s.getId() == id).collect(Collectors.toList());
        logger.info("back list : " + back.toString());
        return back.get(0);
    }
}
