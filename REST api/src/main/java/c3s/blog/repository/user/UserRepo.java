package c3s.blog.repository.user;

import c3s.blog.entity.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import java.util.List;
//import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {
    User findByUserName(String name);
}
