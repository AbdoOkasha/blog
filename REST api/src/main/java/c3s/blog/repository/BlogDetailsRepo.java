package c3s.blog.repository;

import c3s.blog.entity.BlogDetails;
import c3s.blog.entity.PrimaryKey;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableScan
public interface BlogDetailsRepo extends CrudRepository<BlogDetails, PrimaryKey> {
//    BlogDetails findByHashKeyAndRangeKey(String hashKey,String rangeKey);
//    BlogDetails findByRangeKey(String rangeKey);
//    Optional<BlogDetails> findByHashKey(String hashKey);
}
