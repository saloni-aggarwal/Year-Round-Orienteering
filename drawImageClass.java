import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class drawImageClass {

    /**
     * This function draws the path obtained from A* algorithm on the
     * terrain image
     *
     * @param outputImage     File where the modified image with path is stored
     * @param terrainImage    Arraylist of arraylist containing nodes of each pixel
     * @param path            List of path found
     */
    public static void drawImage(String outputImage, String terrainImage,
                                 List<Integer> path) throws IOException {
        //Files to read the image file
        File file = new File(terrainImage);
        BufferedImage img = ImageIO.read(file);

        //For every pixel of path changing pixel colour as red in temp array
        for (int i = 0; i < path.size(); i++) {
            int x = path.get(i);
            int y = path.get(i+1);
            lab1.temp[x][y] = "255/0/0";  //Red RGB Value
            i++;
        }

        //Getting RGB value and setting the updated values in pixel
        for (int x = 0; x < 500; x++) {
            for (int y = 0; y < 395; y++) {
                String value = lab1.temp[x][y];
                String[] rgb = value.split("/");
                int red = Integer.parseInt(rgb[0]);
                int blue = Integer.parseInt(rgb[1]);
                int green = Integer.parseInt(rgb[2]);

                Color color = new Color(red,green,blue);
                img.setRGB(y,x,color.getRGB());
            }
        }
        //Draw image in output file
        file = new File(outputImage);
        ImageIO.write(img,"png",file);
    }
}
