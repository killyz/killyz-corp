import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Workspace {

    public static void main(String[] args) throws IOException {

        try {
            BufferedImage image = ImageIO.read(new File("c:/2.jpg"));
            ImageIO.write(image, "jpg", new File("d:/test.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
