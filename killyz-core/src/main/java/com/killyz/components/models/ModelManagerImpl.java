package com.killyz.components.models;

import com.killyz.application.service.ArtistService;
import com.killyz.application.service.ModelService;
import com.killyz.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelManagerImpl implements ModelManager {

    private final ModelService modelService;
    private final ArtistService artistService;

    @Autowired
    public ModelManagerImpl(ModelService modelService, ArtistService artistService) {
        this.modelService = modelService;
        this.artistService = artistService;
    }

    @Override
    public void save(Model model) {
        if (!artistService.isArtistExists(model.getArtistId()))
            throw new RuntimeException("Cannot save model - artist doesn't exists");

        modelService.save(model);
    }
}
