package com.example.demo.repository.user;

import com.example.demo.entity.FollowDetails;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.resource.list.ResourceList;
import io.crnk.data.jpa.JpaEntityRepositoryBase;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class FollowDetailsRepo extends JpaEntityRepositoryBase<FollowDetails,Integer> {

//    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
//    private Map<Integer,FollowDetails> followDetails = new HashMap<>();

    public FollowDetailsRepo() {
        super(FollowDetails.class);
    }

//    @Override
//    public ResourceList<FollowDetails> findAll(QuerySpec querySpec) {
//        return querySpec.apply(followDetails.values());
//    }
//
//    @Override
//    public <S extends FollowDetails> S save(S details) {
//        if(details.getId() == null){
//            details.setId(ID_GENERATOR.getAndIncrement());
//        }
//        followDetails.put(details.getId(),details);
//        return details;
//    }
//
//    @Override
//    public void delete(Integer id) {
//        followDetails.remove(id);
//    }
}
