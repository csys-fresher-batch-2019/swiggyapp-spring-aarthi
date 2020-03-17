package com.aarthi.aarthihotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
@ServletComponentScan("com.aarthi")
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
public class AarthihotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(AarthihotelApplication.class, args);
	}

}
