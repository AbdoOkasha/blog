//package c3s.blog.repository.comment;
//
//import c3s.blog.entity.Comment;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface CommentRepo extends JpaRepository<Comment,Integer> {
//    List<Comment> findAllByUser_Id(int id);
//    List<Comment> findAllByPost_Id(int id);
//    List<Comment> findAllByPost_IdAndUser_Id(int postId,int userId);
//    int deleteByIdAndUser_Id(int commentId, int userId);
//}
