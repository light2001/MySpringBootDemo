package com.example.demo;

import com.example.demo.config.ApplicationStartup;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class MyApplication {

	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication(MyApplication.class);
		springApplication.addListeners(new ApplicationStartup());
		springApplication.run(args);
	}

}
