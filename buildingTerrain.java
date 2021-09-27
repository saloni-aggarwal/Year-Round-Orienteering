import java.util.ArrayList;

public class buildingTerrain {
    /**
     * This function creates node for each pixel in the image and store the nodes
     * in an arraylist of arraylist based on the location of pixel.
     *
     * @param pixels             2d array of pixels
     * @param elevationPoints    2d array of elevation file
     * @return                   Arraylist of arraylist containing nodes of each pixel
     */
    public static ArrayList<ArrayList<pixelNode>> buildTerrain(String[][] pixels,
                                                               double[][] elevationPoints){
        //Arraylist of arraylist to store nodes of each pixel
        ArrayList<ArrayList<pixelNode>> terrainMap = new ArrayList<>();

        //Storing nodes and assigning elevation, terrain and speed accordingly
        for(int i = 0; i < 500; i++){
            ArrayList<pixelNode> innerList = new ArrayList<>();
            for(int j = 0; j < 395; j++){
                pixelNode temp = new pixelNode(i,j);
                temp.elevation = elevationPoints[i][j];
                temp.terrain = pixels[i][j];
                temp.speed = lab1.speedOnTerrains.get(temp.terrain);
                innerList.add(temp);
            }
            terrainMap.add(innerList);
        }
        return terrainMap;
    }
}
