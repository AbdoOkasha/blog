package com.example.demo.repository.user;

import com.example.demo.entity.User;
//import io.crnk.core.queryspec.QuerySpec;
//import io.crnk.core.repository.ResourceRepositoryBase;
//import io.crnk.core.resource.list.ResourceList;
import io.crnk.data.jpa.JpaEntityRepositoryBase;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class UserRepo extends JpaEntityRepositoryBase<User,Integer> {


    public UserRepo() {
        super(User.class);
    }

}
