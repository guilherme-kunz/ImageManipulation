package src;

import src.model.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("C://Users//guilherme.kunz//IdeaProjects//ImageManipulation//image.png"));
        Image image = new Image(bufferedImage);
        image.ninety(bufferedImage);
        image.OneHundredAndEighty(bufferedImage);
        image.mirrored(bufferedImage);
    }

}

