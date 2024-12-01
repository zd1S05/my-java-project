package com.example.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.app.mapper")
@MapperScan("com.example.app.csv.mapper")
@MapperScan("com.example.app.image.mapper")
@SpringBootApplication
public class SpringItemManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringItemManagerApplication.class, args);
	}

}
