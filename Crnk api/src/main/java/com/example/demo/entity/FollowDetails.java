package com.example.demo.entity;


import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;

import javax.persistence.*;

@Table(
        uniqueConstraints=
        @UniqueConstraint(columnNames={"follower_id", "following_id"})
)
@Entity

@JsonApiResource(type ="followDetails")
@Data
public class FollowDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonApiId
    Integer id;

//    @ManyToOne
//    @JoinColumn(name = "follower_id")
    @JsonApiRelation
    User follower;

//    @ManyToOne
//    @JoinColumn(name = "following_id")
    @JsonApiRelation
    User following;

    public FollowDetails() {
    }

    public FollowDetails(User follower, User following) {
        this.follower = follower;
        this.following = following;
    }


}
