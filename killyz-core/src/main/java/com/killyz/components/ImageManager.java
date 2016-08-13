package com.killyz.components;

import org.springframework.web.multipart.MultipartFile;

public interface ImageManager {

    long uploadImage(MultipartFile imageFile);
}
