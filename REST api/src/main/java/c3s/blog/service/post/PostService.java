//package c3s.blog.service.post;
//
//import c3s.blog.entity.Comment;
//import c3s.blog.entity.Post;
//import c3s.blog.entity.User;
//import c3s.blog.repository.post.PostRepo;
//import c3s.blog.repository.user.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import javax.print.attribute.standard.JobKOctets;
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PostService {
//
//    @Autowired
//    PostRepo postRepo;
//
//    @Autowired
//    UserRepo userRepo;
//
//    public ResponseEntity<Object> addPost(Post post){
//        try{
//            postRepo.save(post);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>("post created successfully ", HttpStatus.ACCEPTED);
//    }
//
//    @Transactional ///?>!@#?>!@#?!#
//    public ResponseEntity deletePost(int postId){
//        try {
//            postRepo.deleteById(postId);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>("post deleted successfully ", HttpStatus.ACCEPTED);
//    }
//
//    public ResponseEntity<Object> addPost(int userId , String text){
//        Optional<User> optionalUser = userRepo.findById(userId);
//        if(!optionalUser.isPresent())
//            return new ResponseEntity<>("couldn't create the post ", HttpStatus.INTERNAL_SERVER_ERROR);
//        Post post = new Post(optionalUser.get(),text);
//        return addPost(post);
//    }
//
//    public Post findById(int id){
//        Optional<Post> optionalPost = postRepo.findById(id);
//        try {
//            return optionalPost.get();
//        } catch (NullPointerException e) {
//            throw new NullPointerException("post not found");
//        }
//    }
//
//    public ResponseEntity<Object> updatePost(int postId,String text){
//        try {
//            Post post = findById(postId);
//            post.setText(text);
//            addPost(post);
//        }catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>("post updated successfully ", HttpStatus.ACCEPTED);
//    }
//
//    public List<Comment> getComments(int postId){
//        Post post = findById(postId);
//        return post.getComments();
//    }
//}
