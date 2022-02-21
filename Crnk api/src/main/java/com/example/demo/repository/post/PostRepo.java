package com.example.demo.repository.post;

import com.example.demo.entity.Post;
import io.crnk.data.jpa.JpaEntityRepositoryBase;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class PostRepo extends JpaEntityRepositoryBase<Post, Integer> {

//    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
//    private Map<Integer,Post> posts = new HashMap<>();

    public PostRepo() {
        super(Post.class);
    }


}
