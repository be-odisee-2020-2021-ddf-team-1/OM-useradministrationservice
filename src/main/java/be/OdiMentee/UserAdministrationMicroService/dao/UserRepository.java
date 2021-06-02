package be.OdiMentee.UserAdministrationMicroService.dao;

import be.OdiMentee.UserAdministrationMicroService.domain.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,String> {

    User findByUsername(String username);

}
