package c3s.blog.service.user;

import c3s.blog.entity.Comment;
import c3s.blog.entity.FollowDetails;
import c3s.blog.entity.Post;
import c3s.blog.entity.User;
import c3s.blog.repository.user.UserRepo;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    FollowDetailsService followDetailsService;

    public ResponseEntity<Object> addUser(User user ){
        try {
            userRepo.save(user);
        } catch (ConstraintViolationException e){
            return new ResponseEntity<>("user name already exists ", HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("user added successfully ",HttpStatus.ACCEPTED);
    }

    public User findByUserName(String userName ){
        return userRepo.findByUserName(userName);
    }

    public User findById(int id){
        Optional<User> optionalUser = userRepo.findById(id);
        try {
            return optionalUser.get();
        } catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        } catch (Exception e){
            throw e;
        }
    }

    public ResponseEntity<Object> followUser(int followerId ,int followedId){
        User follower ;
        User following ;
        try {
            follower = findById(followerId);
            following = findById(followedId);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            followDetailsService.follow(follower, following);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("user followed successfully ",HttpStatus.ACCEPTED);
    }

    public List<User> getFollowers(int userId){
        User user = findById(userId);
        List<FollowDetails> followDetails = user.getFollowers();
        List<User>users = new ArrayList<>();
        for(FollowDetails f : followDetails) users.add(f.getFollower());
        return users;
    }

    public List<User> getFollowing(int userId){
        User user = findById(userId);
        List<FollowDetails> followDetails = user.getFollowing();
        List<User>users = new ArrayList<>();
        for(FollowDetails f : followDetails) users.add(f.getFollowing());
        return users;
    }

    @Transactional
    public ResponseEntity<Object> deleteUser(int userId){
        try {
            userRepo.deleteById(userId);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("user deleted successfully " ,HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> updateUser(User newUser){
        User user = findById(newUser.getId());
        user.setbDate(newUser.getbDate());
        user.setUserName(newUser.getUserName());
        user.setfName(newUser.getfName());
        user.setlName(newUser.getlName());
        try {
            addUser(user);
        } catch (ConstraintViolationException c){
            return new ResponseEntity<>("user name already exists ", HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("user updated successfully ", HttpStatus.ACCEPTED);
    }

    public List<Post> getPosts(int userId){
        try {
            User user = findById(userId);
            return user.getPosts();
        } catch (NullPointerException e){
            throw e;
        } catch (Exception e){
            throw e;
        }
    }

    public List<Comment> getComments(int userId){
        try {
            User user = findById(userId);
            return user.getComments();
        } catch (NullPointerException e){
            throw e;
        } catch (Exception e){
            throw e;
        }
    }
}
