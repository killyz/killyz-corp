package com.killyz.application.service.models;

import com.killyz.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<Model> getAll() {
        return mongoTemplate.find(new Query(), Model.class, modelCollectionName);
    }
}
