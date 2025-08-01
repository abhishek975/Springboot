package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
@SpringBootApplication
public class SpringconfigApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(SpringconfigApplication.class, args);
		
		UserRepository userrepository= context.getBean(UserRepository.class);
		
		User user=new User();
		user.setName("Abhi");
	  userrepository.save(user);
		
	}

}
