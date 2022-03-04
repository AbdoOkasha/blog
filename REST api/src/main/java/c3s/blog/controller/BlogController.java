package c3s.blog.controller;

import c3s.blog.entity.BlogDetails;
import c3s.blog.entity.Comment;
import c3s.blog.entity.Post;
import c3s.blog.entity.User;
import c3s.blog.service.BlogDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "blog")
public class BlogController {

    @Autowired
    BlogDetailsService blogDetailsService;

    @RequestMapping(value = "/addUser" , method = RequestMethod.POST)
    public BlogDetails addUser(@RequestBody User user){
//        System.out.println(user.getUserName());
        return blogDetailsService.addUser(user);
    }



    @RequestMapping(value = "/addPost/{userId}" , method = RequestMethod.POST)
    public BlogDetails addPost(@PathVariable String userId,@RequestBody Post post){
        return blogDetailsService.addPost(userId, post);
    }

    @PostMapping(value = "/addComment/{userId}/{postId}")
    public BlogDetails addComment(@PathVariable String userId ,@PathVariable String postId,@RequestBody Comment comment){
        return blogDetailsService.addComment(userId,postId,comment);
    }

    @RequestMapping(value = "/getByType/{hashKey}/{userName}",method = RequestMethod.GET)
    public List<BlogDetails> getByType(@PathVariable String hashKey, @PathVariable String userName){
        return blogDetailsService.getByType(hashKey,userName);
    }

}
