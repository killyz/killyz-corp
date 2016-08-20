package com.killyz.application.service.models;

import com.killyz.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class ModelServiceImpl implements ModelService {

    private final String modelCollectionName = "models";
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ModelServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(Model model) {
        mongoTemplate.save(model, modelCollectionName);
    }
}
