package c3s.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table
@Entity
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "user_name",unique = true , nullable = false)
    String userName;

    @Column(name = "f_name",nullable = false)
    String fName;

    @Column(name = "l_name",nullable = false)
    String lName;

    @Column(name = "bDate", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    Date bDate;

    @OneToMany(mappedBy = "follower",cascade = CascadeType.REMOVE)
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    List<FollowDetails> following ;

    @OneToMany(mappedBy = "following" , cascade = CascadeType.REMOVE)
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    List<FollowDetails> followers ;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<Comment> comments;

    @OneToMany(mappedBy = "creator",cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<Post> posts;

    public User(){

    }

    public User(String userName, String fName, String lName, Date bDate) {
        this.userName = userName;
        this.fName = fName;
        this.lName = lName;
        this.bDate = bDate;
    }


    public int getId() {
        return id;
    }

    public List<FollowDetails> getFollowers() {
        return followers;
    }

    public List<FollowDetails> getFollowing() {
        return following;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Date getbDate() {
        return bDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }


}
