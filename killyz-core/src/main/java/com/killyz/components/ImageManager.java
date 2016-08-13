package com.killyz.components;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface ImageManager {

    long uploadImage(MultipartFile imageFile);
}
