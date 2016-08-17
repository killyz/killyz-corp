package com.killyz.components.images;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageManager {

    long uploadImage(MultipartFile imageFile) throws IOException;
    String getImageUrl(long modelId);
}
