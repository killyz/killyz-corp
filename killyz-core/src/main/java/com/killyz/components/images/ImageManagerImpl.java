package com.killyz.components.images;

import com.killyz.components.counters.CounterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Component
public class ImageManagerImpl implements ImageManager {

    private final String modelsCounterName = "models";
    private final CounterManager counterManager;

    @Autowired
    public ImageManagerImpl(CounterManager counterManager) {
        this.counterManager = counterManager;
    }

    @Override
    public long uploadImage(MultipartFile imageFile) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageFile.getBytes());
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        long modelId = counterManager.getSequence(modelsCounterName);
        ImageIO.write(bufferedImage, "jpg", new File("C:\\killdb\\warehouse\\models\\" + modelId + ".jpg"));
        return modelId;
    }

    @Override
    public String getImageUrl(long modelId) {
        return "c:\\killdb\\warehouse\\models\\" + modelId + ".jpg";
    }
}
