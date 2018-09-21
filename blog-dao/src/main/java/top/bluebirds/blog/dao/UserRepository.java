package top.bluebirds.blog.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.bluebirds.blog.pojo.User;

public interface UserRepository extends MongoRepository<User,Integer> {

    User findUserById(Integer id);
    User findByUsername(String username);
}
