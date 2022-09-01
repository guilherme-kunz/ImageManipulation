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
    }
    public static void getMatrixOfImage() throws IOException {
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        int[][] pixels = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixels[i][j] = img.getRGB(i, j);
                //System.out.print( pixels[i][j] + " ") ;
            }
        }
        ninety(width, height);
        OneHundredAndEighty(width,height);

//        for (int i = 0; i < 438 ; i++) {
//            for (int j = 0; j < 222; j++) {
//                img.setRGB(i,j,rgb);
//            }
//        }
//        for (int i = 0; i < 438 ; i++) {
//            for (int j = 223; j < 666; j++) {
//                img.setRGB(i,j,rgb);
//            }
//        }
//        for (int i = 439; i < 652 ; i++) {
//            for (int j = 0; j < 222; j++) {
//                img.setRGB(i,j,new Color(255, 255, 255, 255).getRGB());
//            }
//        }
//        for (int i = 653; i < 1312 ; i++) {
//            for (int j = 0; j < 222; j++) {
//                img.setRGB(i,j,new Color(3,12,255).getRGB());
//            }
//        }

    }
    private static void ninety(int width, int height) throws IOException {
        BufferedImage dest = new BufferedImage(height, width, img.getType());
        Graphics2D graphics2D = dest.createGraphics();
        graphics2D.translate((height - width) / 2, (height - width) / 2);
        graphics2D.rotate(Math.PI / 2, height / 2, width / 2);
        graphics2D.drawRenderedImage(img, null);
        File outputfile = new File("90.png");
        ImageIO.write( dest, "png", outputfile);
    }
    private static void OneHundredAndEighty(int width, int height) throws IOException {
        BufferedImage dest = new BufferedImage(height, width, img.getType());
        Graphics2D graphics2D = dest.createGraphics();
        graphics2D.translate((height - width) / 2, (height - width) / 2);
        graphics2D.rotate(Math.PI / 2, height / 2, width / 2);
        graphics2D.drawRenderedImage(img, null);
        File outputfile = new File("180.png");
        ImageIO.write( dest, "png", outputfile);
    }

}
