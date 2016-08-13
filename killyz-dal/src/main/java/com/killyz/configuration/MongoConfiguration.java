package com.killyz.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

//  todo - change localhost hard coded url to an injection

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }

    @Override
    protected String getDatabaseName() {
        return "killdb";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost");
    }

}
