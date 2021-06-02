package be.OdiMentee.UserAdministrationMicroService;

import be.OdiMentee.UserAdministrationMicroService.dao.UserRepository;
import be.OdiMentee.UserAdministrationMicroService.domain.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class UserAdministrationMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAdministrationMicroServiceApplication.class, args);
	}

}
