package com.example.demo.config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext ac = event.getApplicationContext();
        StepExecutor StepExecutor = ac.getBean(StepExecutor .class);
        Thread thread = new Thread(StepExecutor);
        thread.start();
    }
}