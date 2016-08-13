package com.killyz.application.service;

import com.killyz.models.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class CounterServiceImpl implements CounterService {

    private final String counterCollectionName = "counters";
    private final MongoTemplate mongoTemplate;

    @Autowired
    public CounterServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(Counter counter) {
        mongoTemplate.save(counter, counterCollectionName);
    }

    @Override
    public Counter get(String counterName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(counterName));
        return mongoTemplate.findOne(query, Counter.class, counterCollectionName);
    }

    @Override
    public boolean isCounterExists(String counterName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(counterName));
        return mongoTemplate.count(query, counterCollectionName) > 0;
    }
}
