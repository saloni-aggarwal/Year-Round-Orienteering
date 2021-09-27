import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readingElevationFileClass {
    /**
     * This function stores the elevation file according to its location in
     * a 2 dimensional array. Also last 5 values of each line is ignored.
     *
     * @param elevationFile   Elevation file
     * @return                2d array of elevation
     *
     */
    public static double[][] readingElevationFile(String elevationFile) throws FileNotFoundException {
        //Array to store the elevation file
        double [][] elevationPoints = new double[500][395];
        double value;
        //Reading elevation file and storing values
        File file = new File(elevationFile);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()){
            for(int i = 0; i < 500; i++){
                for(int j = 0; j < 400; j++) {
                    value = sc.nextDouble();
                    if(j < 395)
                        elevationPoints[i][j] = value;
                }
            }
        }
        sc.close();
        return elevationPoints;
    }
}
