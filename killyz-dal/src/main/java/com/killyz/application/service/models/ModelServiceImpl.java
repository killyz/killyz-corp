package com.killyz.application.service.models;

import com.killyz.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
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
    public List<Model> getAllForArtist(long artistId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("artistId").is(artistId));
        return mongoTemplate.find(query, Model.class, modelCollectionName);
    }

    @Override
    public List<Model> getAll() {
        return mongoTemplate.find(new Query(), Model.class, modelCollectionName);
    }

    @Override
    public long getNumberOfModels() {
        return mongoTemplate.count(new Query(), modelCollectionName);
    }
}
