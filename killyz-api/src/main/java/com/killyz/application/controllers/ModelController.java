package com.killyz.application.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.killyz.components.ImageManager;
import com.killyz.components.models.ModelManager;
import com.killyz.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

@RestController
@RequestMapping("/model")
public class ModelController {

    private final String modelCounterName = "models";
    private final ModelManager modelManager;
    private final ImageManager imageManager;

    @Autowired
    public ModelController(ModelManager modelManager, ImageManager imageManager) {
        this.modelManager = modelManager;
        this.imageManager = imageManager;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void saveModel(MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
        MultipartFile image = multipartHttpServletRequest.getFile("image");
        long modelId = imageManager.uploadImage(image);
        Model model = new ObjectMapper().readValue(multipartHttpServletRequest.getParameter("model"), Model.class);
        model.setImageUrl(imageManager.getImageUrl(modelId));
        model.set_id(modelId);
        modelManager.save(model);
    }
}
