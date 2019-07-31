package org.macos.java.scheduler;

import org.macos.java.dao.MybatisMySQLDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SynData {

    @Autowired
    private MybatisMySQLDao mybatisMySQLDao;

    @Scheduled(cron = "${polling.schedule.cron:0/2 * * * * ?}")
    public void synQPS() {
        LocalDateTime ldt = LocalDateTime.now();
        String s = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(s);
    }
}
