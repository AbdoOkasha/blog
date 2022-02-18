package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiField;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Setter
@Getter

@JsonApiResource(type ="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonApiId
    Integer id;

//    @ManyToOne
//    @JoinColumn(name = "user_id" , nullable = false)
    @JsonApiRelation
    User creator;

//    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    @JsonApiRelation(opposite = "post")
    @JsonIgnore
    List<Comment> comments;

    @Column(name = "text", nullable = false)
//    @JsonProperty
    @JsonApiField
    String text;

    public Post() {
    }

    public Post(User creator, String text) {
        this.creator = creator;
        this.text = text;
    }


}
