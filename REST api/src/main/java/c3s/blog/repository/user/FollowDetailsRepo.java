//package c3s.blog.repository.user;
//
//import c3s.blog.entity.FollowDetails;
//import c3s.blog.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface FollowDetailsRepo extends JpaRepository<FollowDetails,Integer> {
//    List<FollowDetails> findAllByFollower_Id(int id);
//    List<FollowDetails> findAllByFollowing_Id(int id);
//}
