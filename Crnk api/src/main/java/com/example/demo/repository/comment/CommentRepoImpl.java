package com.example.demo.repository.comment;

import com.example.demo.entity.Comment;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import io.crnk.data.jpa.JpaEntityRepositoryBase;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.security.PermitAll;

@Component
@PermitAll
public class CommentRepoImpl extends JpaEntityRepositoryBase<Comment, Integer> {

//    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
//    private Map<Integer,Comment> comments = new HashMap<>();

    public CommentRepoImpl() {
        super(Comment.class);
    }

}
