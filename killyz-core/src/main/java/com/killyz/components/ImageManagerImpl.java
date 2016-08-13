package com.killyz.components;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageManagerImpl implements ImageManager {
    @Override
    public long uploadImage(MultipartFile imageFile) {
        return 0;
    }
}
