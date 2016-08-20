package com.killyz.application.service.suppliers;

import com.killyz.models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SupplierServiceImpl implements SupplierService {

    private final String supplierCollectionName = "suppliers";
    private final MongoTemplate mongoTemplate;

    @Autowired
    public SupplierServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(Supplier supplier) {
        mongoTemplate.save(supplier, supplierCollectionName);
    }

    @Override
    public List<Supplier> getAll() {
        return mongoTemplate.find(new Query(), Supplier.class, supplierCollectionName);
    }

    @Override
    public void delete(long supplierId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(supplierId));
        mongoTemplate.remove(query, supplierCollectionName);
    }

    @Override
    public boolean isSupplierExists(String supplierNickName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("nickName").is(supplierNickName));
        return mongoTemplate.count(query, supplierCollectionName) > 0;
    }
}
