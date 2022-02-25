//package c3s.blog.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Table
//@Entity
//@Setter
//@Getter
//public class Post {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    int id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id" , nullable = false)
//    User creator;
//
//    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    List<Comment> comments;
//
//    @Column(name = "text", nullable = false)
//    String text;
//
//    public Post() {
//    }
//
//    public Post(User creator, String text) {
//        this.creator = creator;
//        this.text = text;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public User getCreator() {
//        return creator;
//    }
//
//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//}
