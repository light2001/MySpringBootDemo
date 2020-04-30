package com.myspring.cli;

import com.myspring.cli.config.ApplicationStartup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication(MyApplication.class);
		springApplication.addListeners(new ApplicationStartup());
		springApplication.run(args);
	}

}
