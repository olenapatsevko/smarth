package tef.smarth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tef.smarth.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUsername(String username);
}
