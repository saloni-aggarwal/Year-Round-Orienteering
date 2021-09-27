import java.util.ArrayList;

public class winterImageClass {
    /**
     * This function evaluates the path in the winter season. It considers the ice
     * as a path and gives output accordingly.
     * @param terrainMap    Arraylist of arraylist containing nodes of each pixel
     */
    public static void winterImage(ArrayList<ArrayList<pixelNode>> terrainMap){
        //To store if there exists any land pixel just after water pixel
        boolean isLand = false;
        //For every pixel
        for(int i = 0; i < 500; i++){
            for(int j = 0; j < 395; j++){
                //Checking if the pixel is water pixel
                if(terrainMap.get(i).get(j).terrain.equals("0/0/255")){
                    /*
                    If yes then checking if there exists any neighbouring land pixel and updating
                    isLand accordingly
                     */
                    if(!terrainMap.get(i+1).get(j).terrain.equals("0/0/255") ||
                            !terrainMap.get(i+1).get(j).terrain.equals("0/255/255"))
                        isLand = true;
                    else if(!terrainMap.get(i-1).get(j).terrain.equals("0/0/255") ||
                            !terrainMap.get(i-1).get(j).terrain.equals("0/255/255"))
                        isLand = true;
                    else if(!terrainMap.get(i).get(j+1).terrain.equals("0/0/255") ||
                            !terrainMap.get(i).get(j+1).terrain.equals("0/255/255"))
                        isLand = true;
                    else if(!terrainMap.get(i).get(j-1).terrain.equals("0/0/255") ||
                            !terrainMap.get(i).get(j-1).terrain.equals("0/255/255"))
                        isLand = true;
                    else if(!terrainMap.get(i+1).get(j+1).terrain.equals("0/0/255") ||
                            !terrainMap.get(i+1).get(j+1).terrain.equals("0/255/255"))
                        isLand = true;
                    else if(!terrainMap.get(i+1).get(j-1).terrain.equals("0/0/255") ||
                            !terrainMap.get(i+1).get(j-1).terrain.equals("0/255/255"))
                        isLand = true;
                    else if(!terrainMap.get(i-1).get(j+1).terrain.equals("0/0/255") ||
                            !terrainMap.get(i-1).get(j+1).terrain.equals("0/255/255"))
                        isLand = true;
                    else if(!terrainMap.get(i-1).get(j-1).terrain.equals("0/0/255") ||
                            !terrainMap.get(i-1).get(j-1).terrain.equals("0/255/255"))
                        isLand = true;

                    /*
                    If there is a land pixel beside water pixel then updating the 7 neighbouring
                    pixels from the water pixel as snow in the temp and pixels array
                     */
                    if(isLand){
                        for(int x = 0; x < 7; x++){
                            if((j+x) < 394 && !terrainMap.get(i).get(j+x).terrain.equals("0/0/255")) {
                                lab1.temp[i][j + x] = "0/255/255";
                                lab1.pixels[i][j + x] = "0/255/255";
                            }
                            if((j-x) > 0 && !terrainMap.get(i).get(j-x).terrain.equals("0/0/255")) {
                                lab1.temp[i][j - x] = "0/255/255";
                                lab1.pixels[i][j - x] = "0/255/255";
                            }
                            if((i+x) < 499 && !terrainMap.get(i+x).get(j).terrain.equals("0/0/255")) {
                                lab1.temp[i + x][j] = "0/255/255";
                                lab1.pixels[i + x][j] = "0/255/255";
                            }
                            if((i-x) > 0 && !terrainMap.get(i-x).get(j).terrain.equals("0/0/255")) {
                                lab1.temp[i - x][j] = "0/255/255";
                                lab1.pixels[i - x][j] = "0/255/255";
                            }
                            if((i+x) < 499 && (j+x) < 394 && !terrainMap.get(i+x).get(j+x).terrain.equals("0/0/255")) {
                                lab1.temp[i + x][j + x] = "0/255/255";
                                lab1.pixels[i + x][j + x] = "0/255/255";
                            }
                            if((i-x) > 0 && (j+x) < 394 && !terrainMap.get(i-x).get(j+x).terrain.equals("0/0/255")) {
                                lab1.temp[i - x][j + x] = "0/255/255";
                                lab1.pixels[i - x][j + x] = "0/255/255";
                            }
                            if((i-x) > 0 && (j-x) > 0 && !terrainMap.get(i-x).get(j-x).terrain.equals("0/0/255")) {
                                lab1.temp[i - x][j - x] = "0/255/255";
                                lab1.pixels[i - x][j - x] = "0/255/255";
                            }
                            if((i+x) < 499 && (j-x) > 0 && !terrainMap.get(i+x).get(j-x).terrain.equals("0/0/255")) {
                                lab1.temp[i + x][j - x] = "0/255/255";
                                lab1.pixels[i + x][j - x] = "0/255/255";
                            }
                        }
                    }
                }
            }
        }
    }
}
