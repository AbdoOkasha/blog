package com.example.demo.repository.user;

import com.example.demo.entity.User;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class UserRepo extends ResourceRepositoryBase<User,Integer> {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    private Map<Integer,User> users = new HashMap<>();

    public UserRepo() {
        super(User.class);
    }

    @Override
    public ResourceList<User> findAll(QuerySpec querySpec) {
        return querySpec.apply(users.values());
    }

    @Override
    public <S extends User> S save(S user) {
        if(user.getId() == null){
            user.setId(ID_GENERATOR.getAndIncrement());
        }
        users.put(user.getId(),user);
        return user;
    }

    @Override
    public void delete(Integer id) {
        users.remove(id);
    }
}
