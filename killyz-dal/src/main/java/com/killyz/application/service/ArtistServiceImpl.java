package com.killyz.application.service;

import com.killyz.models.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class ArtistServiceImpl implements ArtistService {

    private final String artistCollectionName = "artists";
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ArtistServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(Artist artist) {
        mongoTemplate.save(artist, artistCollectionName);
    }

    @Override
    public boolean isArtistExists(Artist artist) {
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is(artist.getFirstName()));
        query.addCriteria(Criteria.where("lastName").is(artist.getLastName()));
        return mongoTemplate.count(query, artistCollectionName) > 0;
    }

    @Override
    public boolean isArtistExists(long artistId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(artistId));
        return mongoTemplate.count(query, artistCollectionName) > 0;
    }
}
