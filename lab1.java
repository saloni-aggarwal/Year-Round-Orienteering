/**
 * Program name : lab1.java
 *
 * This program generates the optimal paths for orienteering during different seasons
 * (summer, fall, winter and spring) and also considers different terrains and speed
 * on each terrain accordingly.
 *
 * @author    Saloni Aggarwal
 */

import java.util.*;
import java.util.List;


/**
 * This class performs the main task of finding the minimum path by crossing
 * all the checkpoints specified in different seasons
 */
public class lab1 {

    public static String SEASON = "summer";    //season to be considered
    //To store the speed of different terrains
    public static HashMap<String, Float> speedOnTerrains = new HashMap<>();
    //Contains RGB value of each pixel
    public static String [][] pixels = new String[500][395];
    //Contains modified RGB value of each pixel after finding path
    public static String [][] temp = new String[500][395];

    //RGB value of each type of terrain
    static String OPENLAND = "248/148/18";
    static String ROUGHMEADOW = "255/192/0";
    static String EASYMOVEMENTFOREST = "255/255/255";
    static String SLOWRUNFOREST = "2/208/60";
    static String WALKFOREST = "2/136/40";
    static String IMPASSIBLEVEGETATION = "5/73/24";
    static String WATER = "0/0/255";
    static String PAVEDROAD = "71/51/3";
    static String FOOTPATH = "0/0/0";
    static String OUTOFBOUNDS = "205/0/101";
    static String SNOW = "0/255/255";
    static String MUDWATER = "51/0/0";

    //Static block for storing speed of each type of terrain
    static {
        speedOnTerrains.put(OPENLAND,12.5F);
        speedOnTerrains.put(ROUGHMEADOW, 4.0F);
        speedOnTerrains.put(SLOWRUNFOREST, 8.5F);
        speedOnTerrains.put(WALKFOREST, 7.0F);
        speedOnTerrains.put(IMPASSIBLEVEGETATION, 0.001F);
        speedOnTerrains.put(WATER, 0.01F);
        speedOnTerrains.put(PAVEDROAD, 9.0F);
        speedOnTerrains.put(FOOTPATH, 10.0F);
        speedOnTerrains.put(OUTOFBOUNDS, 0.0001F);

    }

    /**
     * The main function
     *
     * @param args   Taking terrain image, elevation file, file consisting of
     *               checkpoints, season and output file name as argument
     */
    public static void main(String[] args) {
        try {
            //Taking and storing arguments
            String terrainImage = args[0];
            String elevationFile = args[1];
            String pathFile = args[2];
            SEASON = args[3];
            String outputFileName = args[4];

            /*
             If the season is fall then the speed on easy movement forest
              decreases
             */
            if(SEASON.equals("fall"))
                speedOnTerrains.put(EASYMOVEMENTFOREST,9.5F);
            else
                speedOnTerrains.put(EASYMOVEMENTFOREST, 11.0F);
            /*
            If the season is winter then consider the ice and update the
            speed for it accordingly.
             */
            if(SEASON.equals("winter"))
                speedOnTerrains.put(SNOW, 6.5F);
            else
                speedOnTerrains.put(SNOW, 0.0F);

            if(SEASON.equals("spring"))
                speedOnTerrains.put(MUDWATER, 1.0F);
            else
                speedOnTerrains.put(MUDWATER, 0.001F);

            //Processing and storing each files received as input
            getPixelsClass.getPixels(terrainImage);
            double[][] elevationPoints = readingElevationFileClass.readingElevationFile(elevationFile);
            int[][] pathPoints = readingPathFileClass.readingPathFile(pathFile);
            ArrayList<ArrayList<pixelNode>> terrainMap = buildingTerrain.buildTerrain(pixels, elevationPoints);
            List<Integer> path = new ArrayList<>();

            /*
            If the season is winter then update the pixels and temp file by creating
            snow pixels around water pixels
             */
            if(SEASON.equals("winter"))
                winterImageClass.winterImage(terrainMap);

            if(SEASON.equals("spring"))
                springImageClass.springImage(terrainMap);

            /*
            For every two points in path file calling the A* algorithm to find an
            optimal path and draw path on image accordingly.
            Also printing the path obtained
             */
            System.out.print("Path is : ");
            for(int i = 0; i < pathPoints.length-1; i++) {
                path = aStarImplementation.aStar(terrainMap.get(pathPoints[i][1]).get(pathPoints[i][0]),
                        terrainMap.get(pathPoints[i + 1][1]).get(pathPoints[i + 1][0]), terrainMap, pixels);
                if (path != null) {
                    drawImageClass.drawImage(outputFileName, terrainImage, path);
                }
                for(int x = path.size()-1; x >= 0; x--){
                    System.out.print(path.get(x) + ", " + path.get(x-1) + " --> ");
                    if(x % 13 == 0)
                        System.out.println();
                    x--;
                }
            }
            System.out.print("Reached goal \n");

            //Printing distance if path is not null
            if (path != null)
                System.out.println("Distance = " + terrainMap.get(path.get(0)).get(path.get(1)).distance * 2);
            else
                System.out.println("Path Not Found");

            //Handling exceptions
        } catch (Exception e){
            System.out.println("Please enter input in the right format");
            System.out.println("It should be specified as : 'terrain-image, " +
                    "elevation-file, path-file, season (summer,fall,winter,or spring " +
                    "(all lowercase letters)), output-image-filename'");
            System.out.println("If the file is in the right format then the error is: ");
            System.out.println(e + " \n" + Arrays.toString(e.getStackTrace()));
        }
    }
}
