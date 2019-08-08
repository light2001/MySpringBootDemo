package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class StepExecutor implements Runnable {
    @Override
    public void run() {
        startStreamTask();

    }
    /**
     * 项目启动后打开1个页面
     */
    public void startStreamTask() {
        try {
            Runtime.getRuntime().exec("cmd   /c   start   http://localhost:9006/swagger-ui.html");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}