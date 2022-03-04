package c3s.blog.service;

import c3s.blog.DynamoConfig;
import c3s.blog.entity.*;
import c3s.blog.repository.BlogDetailsRepo;
//import c3s.blog.repository.DynamoDBCustomRepo;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogDetailsService {


    @Autowired
    BlogDetailsRepo blogDetailsRepo;

    @Autowired
    private DynamoConfig config;
    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
    static DynamoDB dynamoDB = new DynamoDB(client);

    public BlogDetails addUser(User user){
//        AmazonDynamoDB dynamoDB = config.amazonDynamoDB();
//        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

        BlogDetails bD = new BlogDetails(user);
        bD.setHashKey("user");
//        System.out.println(bD.getHashKey() + " " +bD.getByType().getUserName());
//        mapper.save(bD);
        blogDetailsRepo.save(bD);
        return bD;
    }

    public BlogDetails addPost(String userId,Post post){
        PrimaryKey pk = new PrimaryKey("user",userId);
        Optional<BlogDetails> optionalBlogDetails = blogDetailsRepo.findById(pk);
        if(!optionalBlogDetails.isPresent()) throw new NullPointerException("user not found");

        User user = optionalBlogDetails.get().getUser();
        BlogDetails newBD = new BlogDetails(user,post);
        newBD.setHashKey("post");
        blogDetailsRepo.save(newBD);
        return newBD;
    }


    public BlogDetails addComment(String userId, String postId, Comment comment){
        PrimaryKey pk = new PrimaryKey("user",userId);
        Optional<BlogDetails> optionalUserBlog = blogDetailsRepo.findById(pk);

        pk.setHashKey("post");
        pk.setRangeKey(postId);
        Optional<BlogDetails> optionalPostBlog = blogDetailsRepo.findById(pk);

        if(!optionalUserBlog.isPresent())
            throw new NullPointerException("user not found");

        if(!optionalPostBlog.isPresent())
            throw new NullPointerException("post not found");


        User user = (optionalUserBlog.get().getUser());
        Post post =(optionalPostBlog.get().getPost());

        BlogDetails blogDetails = new BlogDetails(user,post,comment);
        blogDetails.setHashKey("comment");

        blogDetailsRepo.save(blogDetails);
        return blogDetails;
    }

    public List<BlogDetails> getByType(String hashKey, String userName){

//        AmazonDynamoDB dynamoDB = config.amazonDynamoDB();
//        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
//
//        mapper.load
//        Table table = dynamoDB.getTable("blogDetails");
//        Item item = table.getItem("hashKey",hashKey,"userName",userName);
//        System.out.println(item.toJSONPretty());
        return blogDetailsRepo.findByHashKeyAndUserName(hashKey,userName);
    }
}
