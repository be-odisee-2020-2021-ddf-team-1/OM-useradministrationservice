package be.OdiMentee.UserAdministrationMicroService;

import be.OdiMentee.UserAdministrationMicroService.dao.UserRepository;
import be.OdiMentee.UserAdministrationMicroService.domain.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserAdministrationMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAdministrationMicroServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepository userRepository) {
		return (ApplicationArguments args) ->  dataSetup(userRepository);
	}

	private void dataSetup(UserRepository userRepository) {
		User test1 = new User(1,"testadmin@gmail.com", "$2a$10$yRxRYK/s8vZCp.bgmZsD/uXmHjekuPU/duM0iPZw04ddt1ID9H7kK", "ROLE_ADMIN");
		User test2 = new User(2,"testuser@gmail.com", "$2a$10$YWDqYU0XJwwBogVycbfPFOnzU7vsG/XvAyQlrN34G/oA1SbhRW.W.", "ROLE_USER");
		userRepository.save(test1);
		userRepository.save(test2);

	}

}
