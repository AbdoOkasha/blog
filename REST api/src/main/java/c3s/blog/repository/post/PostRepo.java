//package c3s.blog.repository.post;
//
//import c3s.blog.entity.Post;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface PostRepo extends JpaRepository<Post,Integer> {
//    List<Post> findAllByCreator_Id(int id);
//    int deleteByIdAndCreator_Id(int postId, int creatorId);
//}
