package c3s.blog.repository;

import c3s.blog.entity.BlogDetails;
import c3s.blog.entity.PrimaryKey;
import c3s.blog.entity.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.util.List;


@Repository
@EnableScan
public interface BlogDetailsRepo extends CrudRepository<BlogDetails, PrimaryKey> {

    List<BlogDetails> findByHashKeyAndUserName(String hashKey, String userName);

}
