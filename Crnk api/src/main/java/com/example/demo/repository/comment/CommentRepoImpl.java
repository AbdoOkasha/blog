package com.example.demo.repository.comment;

import com.example.demo.entity.Comment;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CommentRepoImpl extends ResourceRepositoryBase<Comment, Integer> {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    private Map<Integer,Comment> comments = new HashMap<>();

    public CommentRepoImpl() {
        super(Comment.class);
    }

    @Override
    public ResourceList<Comment> findAll(QuerySpec querySpec) {
        return querySpec.apply(comments.values());
    }

    @Override
    public <S extends Comment> S save(S comment) {
        if(comment.getId() == null){
            comment.setId(ID_GENERATOR.getAndIncrement());
        }
        comments.put(comment.getId(),comment);
        return comment;
    }

    @Override
    public void delete(Integer id) {
        comments.remove(id);
    }
}
