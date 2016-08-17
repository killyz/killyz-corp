package com.killyz.components.models;

import com.killyz.application.service.ArtistService;
import com.killyz.application.service.ModelService;
import com.killyz.components.images.ImageManager;
import com.killyz.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class ModelManagerImpl implements ModelManager {

    private final ImageManager imageManager;
    private final ModelService modelService;
    private final ArtistService artistService;

    @Autowired
    public ModelManagerImpl(ImageManager imageManager, ModelService modelService, ArtistService artistService) {
        this.imageManager = imageManager;
        this.modelService = modelService;
        this.artistService = artistService;
    }

    @Override
    public void save(Model model, MultipartFile imageFile) throws IOException {
        if (!artistService.isArtistExists(model.getArtistId()))
            throw new RuntimeException("Cannot save model. artist doesn't exists");

        long modelId = imageManager.uploadImage(imageFile);
        String imageUrl = imageManager.getImageUrl(modelId);
        model.set_id(modelId);
        model.setImageUrl(imageUrl);
        modelService.save(model);
    }
}

