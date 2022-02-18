package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table
@Entity
@Setter
@Getter
@JsonApiResource(type ="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonApiId
    private Integer id;

    @Column(name = "user_name",unique = true , nullable = false)
    @JsonApiField
    private String userName;

    @Column(name = "f_name",nullable = false)
    @JsonApiField
    private String fName;

    @Column(name = "l_name",nullable = false)
    @JsonApiField
    private String lName;

    @Column(name = "bDate", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @JsonApiField
    private Date bDate;

    @JsonApiRelation(opposite = "follower")
    @JsonIgnore
//    @LazyCollection(LazyCollectionOption.FALSE)
    private List<FollowDetails> following ;

//    @OneToMany(mappedBy = "following" , cascade = CascadeType.REMOVE)
    @JsonApiRelation(opposite = "following")
    @JsonIgnore
//    @LazyCollection(LazyCollectionOption.FALSE)
    private List<FollowDetails> followers ;

//    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    @JsonApiRelation(opposite = "user")
    @JsonIgnore
    private List<Comment> comments;

//    @OneToMany(mappedBy = "creator",cascade = CascadeType.REMOVE)
    @JsonApiRelation(opposite = "creator")
    @JsonIgnore
    private List<Post> posts;


    public User(){

    }

    public User(String userName, String fName, String lName, Date bDate) {
        this.userName = userName;
        this.fName = fName;
        this.lName = lName;
        this.bDate = bDate;
    }





}
