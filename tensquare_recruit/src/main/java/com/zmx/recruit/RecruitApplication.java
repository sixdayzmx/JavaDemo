package com.zmx.recruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@SpringBootApplication
public class RecruitApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecruitApplication.class,args);
	}

	//    将需要的对象加入容器中，这里是一定会执行的，很方便
	@Bean
	public IdWorker idWorker(){
		return new IdWorker(1,1);
	}
}
