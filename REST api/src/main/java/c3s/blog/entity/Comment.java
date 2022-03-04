package c3s.blog.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.*;

//@Table
//@Entity
@Setter
@Getter
@AllArgsConstructor
@DynamoDBDocument
public class Comment {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    @DynamoDBAttribute
//    int id;

//    @ManyToOne
//    @JoinColumn(name = "user_id",nullable = false)
////    @JsonIgnore
//    User user;

//    @ManyToOne
//    @JoinColumn(name = "post_id",nullable = false)
////    @JsonIgnore
//    Post post;

//    @Column(name = "comment",nullable = false)
    @DynamoDBAttribute
    String comment;

    public Comment() {
    }

//    public Comment( Post post, String comment) {
////        this.user = user;
//        this.post = post;
//        this.comment = comment;
//    }

//    public User getByType() {
//        return user;
//    }

//    public Post getPost() {
//        return post;
//    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
