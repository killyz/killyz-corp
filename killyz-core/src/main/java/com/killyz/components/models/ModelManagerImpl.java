package com.killyz.components.models;

import com.killyz.application.service.artists.ArtistService;
import com.killyz.application.service.models.ModelService;
import com.killyz.components.counters.CounterManager;
import com.killyz.components.images.ImageManager;
import com.killyz.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class ModelManagerImpl implements ModelManager {

    private final String modelsCounterName = "models";
    private final CounterManager counterManager;
    private final ImageManager imageManager;
    private final ModelService modelService;
    private final ArtistService artistService;

    @Autowired
    public ModelManagerImpl(CounterManager counterManager, ImageManager imageManager, ModelService modelService, ArtistService artistService) {
        this.counterManager = counterManager;
        this.imageManager = imageManager;
        this.modelService = modelService;
        this.artistService = artistService;
    }

    @Override
    public void save(Model model, MultipartFile imageFile) throws IOException {
        if (!artistService.isArtistExists(model.getArtistId()))
            throw new RuntimeException("Cannot save model. artist doesn't exists");

        resetCounterIfNeeded();
        long modelId = imageManager.uploadImage(imageFile);
        String imageUrl = imageManager.getImageUrl(modelId);
        updateModelCount(model.getArtistId());
        model.set_id(modelId);
        model.setImageUrl(imageUrl);
        modelService.save(model);
    }

    @Override
    public List<Model> getAllForArtist(long artistId) {
        return modelService.getAllForArtist(artistId);
    }

    @Override
    public List<Model> getAll() {
        return modelService.getAll();
    }

    @Override
    public long getNumberOfModels() {
        return modelService.getNumberOfModels();
    }

    private void resetCounterIfNeeded() {
        if (getNumberOfModels() == 0)
            counterManager.resetCounter(modelsCounterName);
    }

    private void updateModelCount(long artistId) {
        artistService.increaseNumberOfModels(artistId);
    }
}

