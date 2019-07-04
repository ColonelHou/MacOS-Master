package org.macos.java.controller;

import org.macos.java.dao.MybatisMySQLDao;
import org.macos.java.dao.beans.ArticleLabel;
import org.macos.java.dao.beans.JobAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @RequestMapping("/saveLabel")
    public String test() {

        /*List<ArticleLabel> list = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            ArticleLabel al = new ArticleLabel();
            al.setArticle_id("1152151=" + i);
            al.setSerial_id("2075" + i);
            al.setBrand_id("20004" + i);
            al.setMaster_brand_ratio(12.0 + i);
            al.setEmotion(0 + i);
            al.setLabel_json("{\"title\":\"nametitle\", \"document\":\"first word" + i + "\"}");
        }
        mybatisMySQLDao.saveList(list);*/

        ArticleLabel al = new ArticleLabel();
        al.setArticle_id("1152151");
        al.setSerial_id("2075");
        al.setBrand_id("20004");
        al.setMaster_brand_ratio(12.0);
        al.setEmotion(0);
        al.setLabel_json("{\"title\":\"nametitle\", \"document\":\"first word\"}");
        mybatisMySQLDao.save(al);
        return "hhhhhhhhhhhh";
    }

    @RequestMapping("/del")
    public void del() {
        mybatisMySQLDao.delById("1152151");
    }
}
