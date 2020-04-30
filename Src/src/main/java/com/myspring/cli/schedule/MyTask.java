package com.myspring.cli.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyTask {

    @Scheduled(cron = "0/10 * * * * *")
    public void work() {
        Date mydate = new Date();
        System.out.println("测试数据:" + mydate.toString());
    }

}
