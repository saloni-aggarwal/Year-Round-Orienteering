import java.util.ArrayList;


public class springImageClass {
    /**
     * This function evaluates the path in the spring season. It considers the mudwater
     * not as a path and gives output accordingly.
     * @param terrainMap    Arraylist of arraylist containing nodes of each pixel
     */
    public static void springImage(ArrayList<ArrayList<pixelNode>> terrainMap) {
        boolean isLand = false;
        //For every pixel
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 395; j++) {
                //Checking if the pixel is water pixel
                if (terrainMap.get(i).get(j).terrain.equals("0/0/255")) {
                    /*
                    If yes then checking if there exists any neighbouring land pixel and updating
                    isLand accordingly
                     */
                    if (!terrainMap.get(i + 1).get(j).terrain.equals("0/0/255") ||
                            !terrainMap.get(i + 1).get(j).terrain.equals("0/255/255"))
                        isLand = true;
                    else if (!terrainMap.get(i - 1).get(j).terrain.equals("0/0/255") ||
                            !terrainMap.get(i - 1).get(j).terrain.equals("0/255/255"))
                        isLand = true;
                    else if (!terrainMap.get(i).get(j + 1).terrain.equals("0/0/255") ||
                            !terrainMap.get(i).get(j + 1).terrain.equals("0/255/255"))
                        isLand = true;
                    else if (!terrainMap.get(i).get(j - 1).terrain.equals("0/0/255") ||
                            !terrainMap.get(i).get(j - 1).terrain.equals("0/255/255"))
                        isLand = true;
                    else if (!terrainMap.get(i + 1).get(j + 1).terrain.equals("0/0/255") ||
                            !terrainMap.get(i + 1).get(j + 1).terrain.equals("0/255/255"))
                        isLand = true;
                    else if (!terrainMap.get(i + 1).get(j - 1).terrain.equals("0/0/255") ||
                            !terrainMap.get(i + 1).get(j - 1).terrain.equals("0/255/255"))
                        isLand = true;
                    else if (!terrainMap.get(i - 1).get(j + 1).terrain.equals("0/0/255") ||
                            !terrainMap.get(i - 1).get(j + 1).terrain.equals("0/255/255"))
                        isLand = true;
                    else if (!terrainMap.get(i - 1).get(j - 1).terrain.equals("0/0/255") ||
                            !terrainMap.get(i - 1).get(j - 1).terrain.equals("0/255/255"))
                        isLand = true;

                    /*
                    If there is a land pixel beside water pixel then updating the 15 neighbouring
                    pixels from the water pixel as mud water in the temp and pixels array or if the
                    elevation of water pixel and neighbouring 15 pixels in less than 1 then make it
                    as mud water
                     */
                    if (isLand) {
                        for (int x = 0; x < 15; x++) {
                            if ((j + x) < 394 && !terrainMap.get(i).get(j + x).terrain.equals("0/0/255") ||
                                    Math.abs(terrainMap.get(i).get(j).elevation -
                                            terrainMap.get(i).get(j + x).elevation) < 1) {
                                lab1.temp[i][j + x] = "51/0/0";
                                lab1.pixels[i][j + x] = "51/0/0";
                            }
                            if ((j - x) > 0 && !terrainMap.get(i).get(j - x).terrain.equals("0/0/255") ||
                                    Math.abs(terrainMap.get(i).get(j).elevation -
                                            terrainMap.get(i).get(j - x).elevation) < 1) {
                                lab1.temp[i][j - x] = "51/0/0";
                                lab1.pixels[i][j - x] = "51/0/0";
                            }
                            if ((i + x) < 499 && !terrainMap.get(i + x).get(j).terrain.equals("0/0/255") ||
                                    Math.abs(terrainMap.get(i).get(j).elevation -
                                            terrainMap.get(i + x).get(j).elevation) < 1) {
                                lab1.temp[i + x][j] = "51/0/0";
                                lab1.pixels[i + x][j] = "51/0/0";
                            }
                            if ((i - x) > 0 && !terrainMap.get(i - x).get(j).terrain.equals("0/0/255") ||
                                    Math.abs(terrainMap.get(i).get(j).elevation -
                                            terrainMap.get(i - x).get(j).elevation) < 1) {
                                lab1.temp[i - x][j] = "51/0/0";
                                lab1.pixels[i - x][j] = "51/0/0";
                            }
                            if ((i + x) < 499 && (j + x) < 394 && !terrainMap.get(i + x).get(j + x).
                                    terrain.equals("0/0/255") || Math.abs(terrainMap.get(i).get(j).elevation -
                                    terrainMap.get(i + x).get(j + x).elevation) < 1) {
                                lab1.temp[i + x][j + x] = "51/0/0";
                                lab1.pixels[i + x][j + x] = "51/0/0";
                            }
                            if ((i - x) > 0 && (j + x) < 394 && !terrainMap.get(i - x).get(j + x).
                                    terrain.equals("0/0/255") || Math.abs(terrainMap.get(i).get(j).elevation -
                                    terrainMap.get(i - x).get(j + x).elevation) < 1) {
                                lab1.temp[i - x][j + x] = "51/0/0";
                                lab1.pixels[i - x][j + x] = "51/0/0";
                            }
                            if ((i - x) > 0 && (j - x) > 0 && !terrainMap.get(i - x).get(j - x).
                                    terrain.equals("0/0/255") || Math.abs(terrainMap.get(i).get(j).elevation -
                                    terrainMap.get(i - x).get(j - x).elevation) < 1) {
                                lab1.temp[i - x][j - x] = "51/0/0";
                                lab1.pixels[i - x][j - x] = "51/0/0";
                            }
                            if ((i + x) < 499 && (j - x) > 0 && !terrainMap.get(i + x).get(j - x).
                                    terrain.equals("0/0/255") || Math.abs(terrainMap.get(i).get(j).elevation -
                                    terrainMap.get(i + x).get(j - x).elevation) < 1) {
                                lab1.temp[i + x][j - x] = "51/0/0";
                                lab1.pixels[i + x][j - x] = "51/0/0";
                            }
                        }
                    }
                }
            }
        }
    }
}