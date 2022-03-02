package c3s.blog.controller;

import c3s.blog.entity.BlogDetails;
import c3s.blog.entity.Post;
import c3s.blog.entity.User;
import c3s.blog.service.BlogDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void addPost(@PathVariable String userId,@RequestBody Post post){
        blogDetailsService.addPost(userId, post);
    }

//    @RequestMapping(value = "/getPost/")

}
