package com.killyz.application.service.models;

import com.killyz.models.Model;

import java.util.List;

public interface ModelService {

    void save(Model model);
    List<Model> getAllForArtist(long artistId);
    List<Model> getAll();
    long getNumberOfModels();

}
