package c3s.blog.controller.post;

import c3s.blog.entity.Post;
import c3s.blog.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/createPost")
    public ResponseEntity<Object> createPost(@RequestBody Post post){
        return postService.addPost(post);
    }

    @PutMapping("/updatePost/{postId}")
    public ResponseEntity<Object> updatePost(@PathVariable int postId,@RequestBody String text){
        return postService.updatePost(postId,text);
    }

    @DeleteMapping("/deletePost/{postId}")
    public ResponseEntity<Object> deletePost(@PathVariable int postId){
        return postService.deletePost(postId);
    }

    @GetMapping("/getPost/{postId}")
    public ResponseEntity<Object> getPost(@PathVariable int postId){
        Post post= postService.findById(postId);
        if(post == null) return new ResponseEntity<>("post not found ", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(post,HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllComments/{postId}")
    public ResponseEntity<Object> getAllComments(@PathVariable int postId){
        return new ResponseEntity<>(postService.getComments(postId),HttpStatus.ACCEPTED);
    }
}
