package com.example.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyTask {
    private final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Scheduled(cron="0/30 * * * * *")
    public void work(){
        Date CurrentDate=new Date();
        System.out.println("方法1，当前时间为："+sdf.format(CurrentDate));
    }

    @Scheduled(fixedDelay = 1000*10)
    public void TestWork(){
        Date CurrentDate=new Date();
        System.out.println("方法2，当前时间为："+sdf.format(CurrentDate));
    }
}
