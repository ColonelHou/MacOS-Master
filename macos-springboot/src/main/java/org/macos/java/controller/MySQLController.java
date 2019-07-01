package org.macos.java.controller;

import org.macos.java.dao.MybatisMySQLDao;
import org.macos.java.dao.beans.JobAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MySQLController {

    @Autowired
    private MybatisMySQLDao mybatisMySQLDao;

    @RequestMapping("/jobAll")
    public String getAllJobs() {
        List<JobAddress> list = mybatisMySQLDao.getAll();
        StringBuffer buffer = new StringBuffer();
        for (JobAddress job : list) {
            buffer.append(job.getJob_id()).append(" ====> ").append(job.getExecutor_address());
        }
        return buffer.toString();
    }

    @RequestMapping("/hj")
    public String test() {

        return "hhhhhhhhhhhh";
    }
}
