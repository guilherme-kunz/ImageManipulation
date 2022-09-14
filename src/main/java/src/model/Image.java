package src.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    private final BufferedImage img;

    public Image(BufferedImage img) {
        this.img = img;
    }

    public int[][] getMatrixOfImage() {
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        int[][] pixels = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixels[i][j] = img.getRGB(i, j);
            }
        }
        return pixels;
    }
    private  void saveImage(File file, BufferedImage bufferedImage) throws IOException {
        ImageIO.write( bufferedImage, "png", file);
    }
    public  void ninety(BufferedImage bufferedImage) throws IOException {
        BufferedImage dest = new BufferedImage(bufferedImage.getHeight(null), bufferedImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = (Graphics2D)dest.getGraphics();
        AffineTransform transform = new AffineTransform();
        transform.setToScale(1, -1);
        transform.translate(0, -bufferedImage.getHeight());
        graphics.rotate(Math.PI / 2, bufferedImage.getHeight(null) / 2, bufferedImage.getHeight(null) / 2);
        graphics.drawRenderedImage(bufferedImage, null);
        File outfile = new File("C://Users//guilherme.kunz//IdeaProjects//ImageManipulation//90.png");
        saveImage(outfile,dest);

    }
    public  void OneHundredAndEighty(BufferedImage bufferedImage) throws IOException {
        BufferedImage dest = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = (Graphics2D)dest.getGraphics();
        AffineTransform transform = new AffineTransform();
        transform.setToScale(1, -1);
        transform.translate(0, -bufferedImage.getHeight());
        graphics.setTransform(transform);
        graphics.drawImage(bufferedImage, 0, 0, null);
        File outfile = new File("C://Users//guilherme.kunz//IdeaProjects//ImageManipulation//180.png");
        saveImage(outfile,dest);
    }
    public  void mirrored(BufferedImage bufferedImage) throws IOException {
        BufferedImage dest = new BufferedImage(bufferedImage.getHeight(null), bufferedImage.getHeight(null),  BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = dest.createGraphics();
        graphics2D.rotate(Math.PI / 2, bufferedImage.getHeight(null) / 2, bufferedImage.getHeight(null) / 2);
        graphics2D.rotate(Math.PI / 2, bufferedImage.getHeight(null) / 2, bufferedImage.getHeight(null) / 2);
        graphics2D.drawRenderedImage(bufferedImage, null);
        for (int y = 0; y < bufferedImage.getHeight(null); y++) {
            for (int lx = 0, rx = bufferedImage.getHeight(null) - 1; lx < bufferedImage.getHeight(null); lx++, rx--) {
                int p = dest.getRGB(lx, y);
                bufferedImage.setRGB(rx, y, p);
            }
            File outfile = new File("C://Users//guilherme.kunz//IdeaProjects//ImageManipulation//mirrored.png");
            saveImage(outfile, dest);
        }
    }

}
