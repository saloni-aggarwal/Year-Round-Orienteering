import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readingPathFileClass {
    /**
     * This function reads the path file that contains all the checkpoints
     * that are needed to be visited and store those points in 2
     * dimensional array
     *
     * @param pathFile   File containing checkpoints
     * @return           2d array containing checkpoints
     */
    public static int[][] readingPathFile(String pathFile) throws FileNotFoundException {
        //Reading pathFile file
        File file = new File(pathFile);
        Scanner sc = new Scanner(file);
        //Calculating number of lines in file
        int lines = 0;
        while (sc.hasNextLine()) {
            sc.nextLine();
            lines++;
        }
        sc.close();
        //Reading pathFile file again and storing values in 2d array
        Scanner scanner = new Scanner(file);
        int[][] pathPoints = new int[lines][2];
        while (scanner.hasNext()){
            for(int i = 0; i < lines; i++)
                for (int j = 0; j < 2; j++) {
                    pathPoints[i][j] = scanner.nextInt();
                }
        }
        scanner.close();
        return pathPoints;
    }
}
