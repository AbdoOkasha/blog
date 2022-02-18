package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@Setter
@Getter

@JsonApiResource(type ="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonApiId
    Integer id;

//    @ManyToOne
//    @JoinColumn(name = "user_id",nullable = false)
    @JsonIgnore
    @JsonApiRelation
    User user;

//    @ManyToOne
//    @JoinColumn(name = "post_id",nullable = false)
    @JsonIgnore
    @JsonApiRelation
    Post post;

    @Column(name = "comment",nullable = false)
//    @JsonProperty
    @JsonApiField
    String comment;

    public Comment() {
    }

    public Comment(User user, Post post, String comment) {
        this.user = user;
        this.post = post;
        this.comment = comment;
    }

}
