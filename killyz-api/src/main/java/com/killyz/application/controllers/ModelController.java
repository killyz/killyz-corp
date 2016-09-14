package com.killyz.application.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.killyz.components.models.ModelManager;
import com.killyz.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/model")
public class ModelController {

    private final ModelManager modelManager;

    @Autowired
    public ModelController(ModelManager modelManager) {
        this.modelManager = modelManager;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void saveModel(MultipartHttpServletRequest request) throws IOException {
        Model model = new ObjectMapper().readValue(request.getParameter("model"), Model.class);
        MultipartFile image = request.getFile("image");
        modelManager.save(model, image);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Model> getAllModels() {
        return modelManager.getAll();
    }

    @RequestMapping(value = "/getAllForArtist", method = RequestMethod.GET)
    public List<Model> getAllModelsForArtist(@RequestParam long artistId) {
        return modelManager.getAllForArtist(artistId);
    }
}
