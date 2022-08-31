package src;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {
    static Color myWhite = new Color(0,0,0);// Color white
    static int rgb = myWhite.getRGB();
    static  BufferedImage img;

    public static void main(String[] args) throws IOException {
        img= ImageIO.read(new File("C://Users//guilh//IdeaProjects//ImageManipulation//src//main//java//src//image.jpg"));
        getMatrixOfImage();
        File outputfile = new File("saved.png");
        ImageIO.write( img, "png", outputfile);
    }
    public static void getMatrixOfImage() {
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        int[][] pixels = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixels[i][j] = img.getRGB(i, j);
                System.out.print( pixels[i][j] + " ") ;
            }
        }

        for (int i = 0; i < width /2 ; i++) {
            for (int j = 0; j < height; j++) {
                img.getRaster().getDataElements(i,j,null);
                img.setRGB(i,j,rgb);
            }
        }
    }

}
