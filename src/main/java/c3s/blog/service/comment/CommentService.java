package c3s.blog.service.comment;

import c3s.blog.dto.commentDto.CommentDTO;
import c3s.blog.entity.Comment;
import c3s.blog.entity.Post;
import c3s.blog.entity.User;
import c3s.blog.repository.comment.CommentRepo;
import c3s.blog.service.post.PostService;
import c3s.blog.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public ResponseEntity<Object> addComment(Comment comment){
        try{
            commentRepo.save(comment);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("comment Added successfully", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> addComment(CommentDTO commentDTO){
        User user = userService.findById(commentDTO.getUserDTO().getId());
        Post post = postService.findById(commentDTO.getPostDTO().getId());
        Comment comment = new Comment(user,post,commentDTO.getComment());
        try{
            commentRepo.save(comment);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("comment Added successfully", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> addComment(int userId , int postId , String msg){
        User user = userService.findById(userId);
        Post post = postService.findById(postId);
        Comment comment = new Comment(user,post,msg);
        return addComment(comment);
    }

    public Comment findById(int id){
        Optional<Comment> optionalComment = commentRepo.findById(id);
        try {
            return optionalComment.get();
        } catch (NullPointerException e) {
            throw new NullPointerException("comment not found");
        }
    }

    public List<Comment> getCommentsOfPost(int userId, int postId){
        return commentRepo.findAllByPost_IdAndUser_Id(postId,userId);
    }

    @Transactional
    public ResponseEntity<Object> deleteComment(int commentId){
        try{
            commentRepo.deleteById(commentId);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("comment deleted successfully", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> updateComment(int commentId , String msg){
        try {
            Comment comment = findById(commentId);
            comment.setComment(msg);
            addComment(comment);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("comment updated successfully", HttpStatus.ACCEPTED);
    }

}
