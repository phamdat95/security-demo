package com.example.bootemo;

import com.example.bootemo.service.GroupService;
import com.example.bootemo.service.StaffService;
import com.example.bootemo.service.imp.GroupServiceImp;
import com.example.bootemo.service.imp.StaffServiceImp;
import com.example.bootemo.service.imp.UserDetailsServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
public class BootemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootemoApplication.class, args);
	}
	@Bean
	public StaffService staffService(){return new StaffServiceImp();
	}
	@Bean
	public GroupService groupService(){return new GroupServiceImp();
	}
	@Bean
	public UserDetailsService userDetailsService(){return new UserDetailsServiceImpl();
	}
}

