package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.crnk.core.resource.annotations.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
//@Setter
//@Getter
@Data
@JsonApiResource(type ="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonApiId
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
//    @JsonIgnore
    @JsonApiRelation(repositoryBehavior = RelationshipRepositoryBehavior.FORWARD_OWNER)
    User user;

    @ManyToOne
    @JoinColumn(name = "post_id",nullable = false)
//    @JsonIgnore
    @JsonApiRelation(repositoryBehavior = RelationshipRepositoryBehavior.FORWARD_OWNER)
    Post post;

    @Column(name = "comment",nullable = false)
    @JsonApiField
    String comment;

    public Comment() {
    }

    public Comment(User user,Post post, String comment) {
        this.user = user;
        this.post = post;
        this.comment = comment;
    }


}
