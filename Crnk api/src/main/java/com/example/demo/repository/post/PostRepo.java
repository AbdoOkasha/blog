package com.example.demo.repository.post;

import com.example.demo.entity.Post;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class PostRepo extends ResourceRepositoryBase<Post, Integer> {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    private Map<Integer,Post> posts = new HashMap<>();

    public PostRepo() {
        super(Post.class);
    }

    @Override
    public ResourceList<Post> findAll(QuerySpec querySpec) {
        return querySpec.apply(posts.values());
    }

    @Override
    public <S extends Post> S save(S post) {
        if(post.getId() == null){
            post.setId(ID_GENERATOR.getAndIncrement());
        }
        posts.put(post.getId(),post);
        return post;
    }

    @Override
    public void delete(Integer id) {
        posts.remove(id);
    }

}
