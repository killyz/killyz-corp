package com.killyz.application.controllers;

import com.killyz.components.CounterManager;
import com.killyz.components.ImageManager;
import com.killyz.components.ModelManager;
import com.killyz.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/model")
public class ModelController {

    private final String modelCounterName = "models";
    private final CounterManager counterManager;
    private final ModelManager modelManager;
    private final ImageManager imageManager;

    @Autowired
    public ModelController(CounterManager counterManager, ModelManager modelManager, ImageManager imageManager) {
        this.counterManager = counterManager;
        this.modelManager = modelManager;
        this.imageManager = imageManager;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void saveModel(@RequestParam("image") MultipartFile file, @RequestBody Model model) throws IOException {
        long modelId = imageManager.uploadImage(file);
        model.set_id(modelId);
        modelManager.save(model);
    }

}
