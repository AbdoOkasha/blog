//package c3s.blog;
//
//import c3s.blog.entity.Comment;
//import c3s.blog.entity.Post;
//import c3s.blog.entity.User;
//import c3s.blog.service.comment.CommentService;
//import c3s.blog.service.post.PostService;
//import c3s.blog.service.user.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class Config implements CommandLineRunner {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    PostService postService;
//
//    @Autowired
//    CommentService commentService;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        User user1 = new User("okasha","abdo","mohamed",22);
//        User user2 = new User("okasha2","abdo","mohamed",22);
//        userService.addUser(user1);
//        userService.addUser(user2);
//        userService.followUser(1,2);
//        userService.followUser(2,2);
//        userService.followUser(1,1);
//
//        List<User> followers = userService.getFollowers(1);
//        for(User user : followers) System.out.println(user.getId() );
//        System.out.println("followers number is "+followers.size());
//        User user = userService.findByUserName("okasha");
//
////        userService.addUser(user);
//
//        Post post = new Post(user ,"ana ana ana anaaa");
//
//        postService.addPost(1,"bteeeeeeeeeee5");
//        postService.addPost(post);
//
//
//        commentService.addComment(1,1,"oh yeaaaah");
//        commentService.addComment(2,2,"oh nooooo");
//        List<Comment> comments = commentService.getCommentsOfPost(1,2);
//        commentService.updateComment(1,"hhhhhhhhhhh");
////        for(Comment comment : comments) System.out.println(comment.getComment());
////        commentService.deleteComment(2,1);
//        postService.deletePost(2,1);
//        userService.deleteUser(1);
////        postService.updatePost(2,"updated post");
//        userService.updateUser(1,"okasha","abdo","okasha",22);
//    }
//}
