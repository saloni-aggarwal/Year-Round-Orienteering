import java.awt.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.imageio.ImageIO;
public class GetPixels {
    static String OPENLAND = "148/248/18";
    static String ROUGHMEADOW = "255/192/0";
    static String EASYMOVEMENTFOREST = "255/255/255";
    static String SLOWRUNFOREST = "2/208/60";

    public static HashMap<String, Float> dictionary = new HashMap<>();

    public static void main(String args[])throws Exception {
        dictionary.put(OPENLAND, 4.5F);
        dictionary.put(ROUGHMEADOW, 2.3F);
        dictionary.put(EASYMOVEMENTFOREST, 4.8F);
        dictionary.put(SLOWRUNFOREST,2.5F);
        System.out.println(dictionary.get(OPENLAND));
            if(dictionary.containsKey("2/208/60"))
                System.out.println(dictionary.get("2/208/60"));



//        FileWriter writer = new FileWriter("Output.txt");
        String[][] pixels = new String[500][395];
        //Reading the image
        File file= new File("terrain.png");
        BufferedImage img = ImageIO.read(file);
        System.out.println(img.getHeight() + " " +img.getWidth());
        for (int x = 0; x < img.getHeight(); x++) {
            for (int y = 0; y < img.getWidth(); y++) {
                //Retrieving contents of a pixel
                Color c = new Color(img.getRGB(y,x));
                pixels[x][y] = c.getRed()+"/"+c.getGreen()+"/"+c.getBlue();
            }
        }
//        for (int x = 0; x < img.getHeight(); x++) {
//            for (int y = 0; y < img.getWidth(); y++) {
//                System.out.println(x + "  " +pixels[x][y]);
//            }
//        }
        System.out.println("RGB values at each pixel are stored in the specified file");
    }
}
