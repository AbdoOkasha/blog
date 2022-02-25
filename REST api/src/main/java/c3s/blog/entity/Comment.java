//package c3s.blog.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Table
//@Entity
//@Setter
//@Getter
//public class Comment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    int id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id",nullable = false)
////    @JsonIgnore
//    User user;
//
//    @ManyToOne
//    @JoinColumn(name = "post_id",nullable = false)
////    @JsonIgnore
//    Post post;
//
//    @Column(name = "comment",nullable = false)
//    String comment;
//
//    public Comment() {
//    }
//
//    public Comment(User user, Post post, String comment) {
//        this.user = user;
//        this.post = post;
//        this.comment = comment;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public Post getPost() {
//        return post;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//}
