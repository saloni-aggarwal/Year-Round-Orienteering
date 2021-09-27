import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class getPixelsClass {
    /**
     * This method stores the RGB value for each pixel of terrain image
     *
     * @param  terrainImage    Terrain image
     */
    public static void getPixels(String terrainImage) throws IOException {
        //Reading the image
        File file= new File(terrainImage);
        BufferedImage img = ImageIO.read(file);
        for (int x = 0; x < img.getHeight(); x++) {
            for (int y = 0; y < img.getWidth(); y++) {
                //Getting the values of the pixels
                Color c = new Color(img.getRGB(y,x));
                //Storing the reg, green and blue values as String in pixel and temp array
                lab1.pixels[x][y] = c.getRed()+"/"+c.getGreen()+"/"+c.getBlue();
                lab1.temp[x][y] = c.getRed()+"/"+c.getGreen()+"/"+c.getBlue();
            }
        }
    }
}
