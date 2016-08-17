package com.killyz.components.models;

import com.killyz.application.service.ModelService;
import com.killyz.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelManagerImpl implements ModelManager {

    private final ModelService modelService;

    @Autowired
    public ModelManagerImpl(ModelService modelService) {
        this.modelService = modelService;
    }

    @Override
    public void save(Model model) {
        modelService.save(model);
    }
}
