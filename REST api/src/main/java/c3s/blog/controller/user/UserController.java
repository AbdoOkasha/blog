package c3s.blog.controller.user;

import c3s.blog.entity.User;
import c3s.blog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable int userId){
        return userService.deleteUser(userId);
    }

    @PutMapping( "/updateUser")
    public ResponseEntity<Object> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @GetMapping( "/findUser/{userId}")
    public ResponseEntity<Object> findUser(@PathVariable("userId") int userId){
        User user = userService.findById(userId);
        if(user == null) return new ResponseEntity<>("couldn't find the user " , HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(user ,HttpStatus.ACCEPTED);
    }

//    @PostMapping("/followUser/{followerId}/{followingId}")
//    public ResponseEntity<Object> followUser(@PathVariable int followerId , @PathVariable int followingId){
//        return userService.followUser(followerId,followingId);
//    }

//    @GetMapping( "/getFollowers/{userId}")
//    public ResponseEntity<Object> getFollowers(@PathVariable("userId") int userId){
//        return new ResponseEntity<>( userService.getFollowers(userId),HttpStatus.ACCEPTED );
//
//    }
//
//    @GetMapping( "/getFollowing/{userId}")
//    public ResponseEntity<Object> getFollowing(@PathVariable("userId") int userId){
//        return new ResponseEntity<>( userService.getFollowing(userId),HttpStatus.ACCEPTED );
//    }
//
//    @GetMapping("/getAllPosts/{userId}")
//    public ResponseEntity<Object> getAllPosts(@PathVariable int userId){
//        try{
//            return new ResponseEntity<>(userService.getPosts(userId),HttpStatus.ACCEPTED);
//        } catch (Exception e){
//            return  new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/getAllComments/{userId}")
//    public ResponseEntity<Object> getAllComments(@PathVariable int userId){
//        try {
//            return new ResponseEntity<>(userService.getComments(userId), HttpStatus.ACCEPTED);
//        } catch (Exception e){
//            return  new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}
