package c3s.blog.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;
//import org.hibernate.annotations.LazyCollection;
//import org.hibernate.annotations.LazyCollectionOption;
//
//import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table
@Entity
@Setter
@Getter
//@DynamoDBTable(tableName = "user")
//@DynamoDBDocument
public class User implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    @Column(name = "user_name",unique = true , nullable = false)
    @DynamoDBAttribute
    @NotNull
    @JsonProperty("userName")
    String userName;

//    @Column(name = "f_name",nullable = false)
    @DynamoDBAttribute
    String fName;

//    @Column(name = "l_name",nullable = false)
    @DynamoDBAttribute
    String lName;

//    @Column(name = "bDate", nullable = false)
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Temporal(TemporalType.DATE)
    @DynamoDBAttribute
    Date bDate;

//    @OneToMany(mappedBy = "follower",cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @DynamoDBAttribute
//    List<FollowDetails> following ;
//
//    @OneToMany(mappedBy = "following" , cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    @LazyCollection(LazyCollectionOption.FALSE)
//    List<FollowDetails> followers ;
//
//    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    @DynamoDBAttribute
//    List<Comment> comments;
//
//    @OneToMany(mappedBy = "creator",cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    @DynamoDBAttribute
//    List<Post> posts;

    public User(){

    }

    public User(String userName, String fName, String lName, Date bDate) {
        this.userName = userName;
        this.fName = fName;
        this.lName = lName;
        this.bDate = bDate;
    }

    public User(String userName) {
        this.userName = userName;
    }

//    public String getId() {
//        return id;
//    }

//    public List<FollowDetails> getFollowers() {
//        return followers;
//    }
//
//    public List<FollowDetails> getFollowing() {
//        return following;
//    }
//
//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public List<Post> getPosts() {
//        return posts;
//    }

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
