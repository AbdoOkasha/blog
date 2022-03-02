package c3s.blog.service;

import c3s.blog.entity.BlogDetails;
import c3s.blog.entity.Post;
import c3s.blog.entity.PrimaryKey;
import c3s.blog.entity.User;
import c3s.blog.repository.BlogDetailsRepo;
//import c3s.blog.repository.DynamoDBCustomRepo;
import com.amazonaws.services.dynamodbv2.document.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogDetailsService {


    @Autowired
    BlogDetailsRepo blogDetailsRepo;


    public BlogDetails addUser(User user){
        BlogDetails bD = new BlogDetails(user);
        bD.setHashKey("user");
//        System.out.println(bD.getHashKey() + " " +bD.getUser().getUserName());
        blogDetailsRepo.save(bD);
        return bD;
    }

    public void addPost(String userId,Post post){
        PrimaryKey pk = new PrimaryKey("user",userId);
//        System.out.println(pk.getRangeKey());
        Optional<BlogDetails> optionalBlogDetails =null;
//        List<BlogDetails> list = (List<BlogDetails>) blogDetailsRepo.findAll();
//        System.out.println("list size is "+list.size());
        try {
            optionalBlogDetails = blogDetailsRepo.findById(pk);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(!optionalBlogDetails.isPresent()) System.out.println("user not found ");
        BlogDetails bD = optionalBlogDetails.get();
        User user = bD.getUser();
//        System.out.println(user.getUserName());
//        bD.setPosts(post);
//        User user = bD.getUser();
        BlogDetails newBD = new BlogDetails(user,post);
        newBD.setHashKey("post");
//        blogDetailsRepo.save(bD);
        blogDetailsRepo.save(newBD);
    }
}
