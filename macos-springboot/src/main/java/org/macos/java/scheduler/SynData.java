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

    @Scheduled(cron = "${polling.schedule.cron:0 48 16 * * ?}")
    public void synQPS() {
        LocalDateTime ldt = LocalDateTime.now().minusDays(1);
        String s = ldt.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(s);

        mybatisMySQLDao.aggQpsHistory(s);
    }
}
