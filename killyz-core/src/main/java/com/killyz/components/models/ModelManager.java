package com.killyz.components.models;

import com.killyz.models.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ModelManager {

    void save(Model model, MultipartFile imageFile) throws IOException;
}
