package c3s.blog.entity;


import javax.persistence.*;

@Table(
        uniqueConstraints=
        @UniqueConstraint(columnNames={"follower_id", "following_id"})
)
@Entity
public class FollowDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    User follower;

    @ManyToOne
    @JoinColumn(name = "following_id")
    User following;

    public FollowDetails() {
    }

    public FollowDetails(User follower, User following) {
        this.follower = follower;
        this.following = following;
    }

    public User getFollower() {
        return follower;
    }

    public User getFollowing() {
        return following;
    }
}
