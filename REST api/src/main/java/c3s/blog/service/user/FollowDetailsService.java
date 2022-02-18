package c3s.blog.service.user;

import c3s.blog.entity.FollowDetails;
import c3s.blog.entity.User;
import c3s.blog.repository.user.FollowDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowDetailsService {

    @Autowired
    FollowDetailsRepo followDetailsRepo;

    public void follow(User follower , User following){
        try {
            FollowDetails followDetails = new FollowDetails(follower, following);
            followDetailsRepo.save(followDetails);
        } catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("user already followed");
        } catch (Exception e){
            throw e;
        }

    }

    public List<FollowDetails> getFollowers(int userId){
        return followDetailsRepo.findAllByFollowing_Id(userId);
    }

    public List<FollowDetails> getFollowing(int userId){
        return followDetailsRepo.findAllByFollower_Id(userId);
    }
}
