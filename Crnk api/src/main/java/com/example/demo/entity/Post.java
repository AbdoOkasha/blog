package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
//@Setter
//@Getter
@Data
@JsonApiResource(type ="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonApiId
    int id;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    @JsonApiRelation(repositoryBehavior = RelationshipRepositoryBehavior.FORWARD_OWNER)
    User creator;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    @JsonApiRelation(mappedBy = "post")
//    @JsonIgnore
    @JsonBackReference
    private List<Comment> comments;

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
