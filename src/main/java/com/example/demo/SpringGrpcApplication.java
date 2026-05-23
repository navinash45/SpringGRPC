package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.grpc.client.GreeterClient;

@SpringBootApplication
public class SpringGrpcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGrpcApplication.class, args);
	}


	@RestController
	class GRPCControllerUIController{
		
		@Autowired
	    GreeterClient greeterClient;

		@GetMapping("/hello")
		public String sayHello(@RequestParam String name ,@RequestParam String city) {
			return greeterClient.sayHello(name, city);	
		}
		
	}
}
