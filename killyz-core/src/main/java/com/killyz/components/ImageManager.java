package com.killyz.components;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageManager {

    long uploadImage(MultipartFile imageFile) throws IOException;
}
