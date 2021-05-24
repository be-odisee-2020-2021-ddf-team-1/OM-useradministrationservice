package be.OdiMentee.UserAdministrationMicroService.dao;

import be.OdiMentee.UserAdministrationMicroService.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    Optional<User> findByEmail(String username);


}
