import java.util.ArrayList;

public class findingNeighbours {

    /**
     * This function finds neighbours for a particular node according to its bounds
     *
     * @param parent        Node whose neighbours are to be found
     * @param pixels        2d array of pixels
     * @param terrainMap    Arraylist of arraylist containing nodes of each pixel
     * @return              Arraylist containing all neighbouring nodes
     */
    public static ArrayList<pixelNode> getNeighbours(pixelNode parent, String[][] pixels,
                                                     ArrayList<ArrayList<pixelNode>> terrainMap){
        int x = parent.x;    //x - axis of node
        int y = parent.y;    //y - axis of node
        //Arraylist to store all the nodes
        ArrayList<pixelNode> neighbours = new ArrayList<>();

        //Finding neighbours according to its bounds or location
        //When pixel is in upper leftmost corner
        if(x == 0 && y == 0){
            if(lab1.speedOnTerrains.get(pixels[x][y+1]) > 0)
                neighbours.add(terrainMap.get(x).get(y+1));
            if(lab1.speedOnTerrains.get(pixels[x+1][y+1]) > 0)
                neighbours.add(terrainMap.get(x+1).get(y+1));
            if (lab1.speedOnTerrains.get(pixels[x + 1][y]) > 0)
                neighbours.add(terrainMap.get(x + 1).get(y));
            //When pixel is in upper rightmost corner
        } else if(x == 0 && y == 394) {
            if (lab1.speedOnTerrains.get(pixels[x][y-1]) > 0)
                neighbours.add(terrainMap.get(x).get(y-1));
            if (lab1.speedOnTerrains.get(pixels[x + 1][y - 1]) > 0)
                neighbours.add(terrainMap.get(x + 1).get(y - 1));
            if (lab1.speedOnTerrains.get(pixels[x + 1][y]) > 0)
                neighbours.add(terrainMap.get(x + 1).get(y));
            //When pixel lies in uppermost border
        } else if(x == 0 && (y > 0 && y < 394)){
            if(lab1.speedOnTerrains.get(pixels[x][y+1]) > 0)
                neighbours.add(terrainMap.get(x).get(y+1));
            if(lab1.speedOnTerrains.get(pixels[x][y-1]) > 0)
                neighbours.add(terrainMap.get(x).get(y-1));
            if(lab1.speedOnTerrains.get(pixels[x+1][y+1]) > 0)
                neighbours.add(terrainMap.get(x+1).get(y+1));
            if(lab1.speedOnTerrains.get(pixels[x+1][y-1]) > 0)
                neighbours.add(terrainMap.get(x+1).get(y-1));
            if (lab1.speedOnTerrains.get(pixels[x+1][y]) > 0)
                neighbours.add(terrainMap.get(x+1).get(y));
            //When pixel lies in lower left corner
        } else if(x == 499 && y == 0) {
            if (lab1.speedOnTerrains.get(pixels[x][y + 1]) > 0)
                neighbours.add(terrainMap.get(x).get(y + 1));
            if (lab1.speedOnTerrains.get(pixels[x - 1][y + 1]) > 0)
                neighbours.add(terrainMap.get(x - 1).get(y + 1));
            if (lab1.speedOnTerrains.get(pixels[x - 1][y]) > 0)
                neighbours.add(terrainMap.get(x - 1).get(y));
            //When pixel lies in lower right corner
        } else if(x == 499 && y == 394) {
            if (lab1.speedOnTerrains.get(pixels[x][y - 1]) > 0)
                neighbours.add(terrainMap.get(x).get(y - 1));
            if (lab1.speedOnTerrains.get(pixels[x - 1][y - 1]) > 0)
                neighbours.add(terrainMap.get(x - 1).get(y - 1));
            if (lab1.speedOnTerrains.get(pixels[x - 1][y]) > 0)
                neighbours.add(terrainMap.get(x - 1).get(y));
            //When pixel lies on lower border
        } else if(x == 499 && (y > 0 && y < 394)){
            if(lab1.speedOnTerrains.get(pixels[x][y+1]) > 0)
                neighbours.add(terrainMap.get(x).get(y+1));
            if(lab1.speedOnTerrains.get(pixels[x][y-1]) > 0)
                neighbours.add(terrainMap.get(x).get(y-1));
            if(lab1.speedOnTerrains.get(pixels[x-1][y+1]) > 0)
                neighbours.add(terrainMap.get(x-1).get(y+1));
            if(lab1.speedOnTerrains.get(pixels[x-1][y-1]) > 0)
                neighbours.add(terrainMap.get(x-1).get(y-1));
            if (lab1.speedOnTerrains.get(pixels[x - 1][y]) > 0)
                neighbours.add(terrainMap.get(x - 1).get(y));
            //When pixel lies on left border
        } else if((x > 0 && x < 499) && y == 0) {
            if (lab1.speedOnTerrains.get(pixels[x][y + 1]) > 0)
                neighbours.add(terrainMap.get(x).get(y + 1));
            if (lab1.speedOnTerrains.get(pixels[x + 1][y + 1]) > 0)
                neighbours.add(terrainMap.get(x + 1).get(y + 1));
            if (lab1.speedOnTerrains.get(pixels[x - 1][y + 1]) > 0)
                neighbours.add(terrainMap.get(x - 1).get(y + 1));
            if (lab1.speedOnTerrains.get(pixels[x - 1][y]) > 0)
                neighbours.add(terrainMap.get(x - 1).get(y));
            if (lab1.speedOnTerrains.get(pixels[x + 1][y]) > 0)
                neighbours.add(terrainMap.get(x + 1).get(y));
            //When pixel lies on right border
        } else if ((x > 0 && x < 499) && y == 394) {
            if (lab1.speedOnTerrains.get(pixels[x][y - 1]) > 0)
                neighbours.add(terrainMap.get(x).get(y - 1));
            if (lab1.speedOnTerrains.get(pixels[x + 1][y - 1]) > 0)
                neighbours.add(terrainMap.get(x + 1).get(y - 1));
            if (lab1.speedOnTerrains.get(pixels[x - 1][y - 1]) > 0)
                neighbours.add(terrainMap.get(x - 1).get(y - 1));
            if (lab1.speedOnTerrains.get(pixels[x - 1][y]) > 0)
                neighbours.add(terrainMap.get(x - 1).get(y));
            if (lab1.speedOnTerrains.get(pixels[x + 1][y]) > 0)
                neighbours.add(terrainMap.get(x + 1).get(y));
            //When pixel lies somewhere between other pixels
        } else{
            if(lab1.speedOnTerrains.get(pixels[x][y-1]) > 0)
                neighbours.add(terrainMap.get(x).get(y - 1));
            if(lab1.speedOnTerrains.get(pixels[x+1][y-1]) > 0)
                neighbours.add(terrainMap.get(x + 1).get(y - 1));
            if(lab1.speedOnTerrains.get(pixels[x+1][y]) > 0)
                neighbours.add(terrainMap.get(x + 1).get(y));
            if(lab1.speedOnTerrains.get(pixels[x+1][y+1]) > 0)
                neighbours.add(terrainMap.get(x+1).get(y+1));
            if(lab1.speedOnTerrains.get(pixels[x][y+1]) > 0)
                neighbours.add(terrainMap.get(x).get(y+1));
            if(lab1.speedOnTerrains.get(pixels[x-1][y+1]) > 0)
                neighbours.add(terrainMap.get(x-1).get(y+1));
            if(lab1.speedOnTerrains.get(pixels[x-1][y]) > 0)
                neighbours.add(terrainMap.get(x-1).get(y));
            if(lab1.speedOnTerrains.get(pixels[x-1][y-1]) > 0)
                neighbours.add(terrainMap.get(x-1).get(y-1));
        }
        return neighbours;
    }
}
