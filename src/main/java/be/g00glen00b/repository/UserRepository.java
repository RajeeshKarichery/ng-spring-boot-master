package be.g00glen00b.repository;

import org.springframework.data.repository.CrudRepository;
import be.g00glen00b.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
