import java.util.ArrayList;
import java.util.List;

public class aStarImplementation {
    /**
     * This is the main function to find the optimal path between two points
     * using A* algorithm
     *
     * @param source        starting node
     * @param destination   destination node
     * @param terrainMap    Arraylist of arraylist containing nodes of each pixel
     * @param pixels        2d array of pixels
     * @return              an Arraylist containing path from source to destination
     */
    public static List<Integer> aStar(pixelNode source, pixelNode destination,
                                      ArrayList<ArrayList<pixelNode>> terrainMap,
                                      String[][] pixels){
        //If terrain of source has speed below zero
        if(source.speed < 0){
            System.out.println("Source is out of bounds");
            return null;
        }
        //If terrain of destination has speed below zero
        if(destination.speed < 0){
            System.out.println("Destination is out of bounds");
            return null;
        }
        //Arraylist containing nodes from which next node is to be chosen
        ArrayList<pixelNode> frontier = new ArrayList<>();
        //Arraylist containing nodes that have been explored already
        ArrayList<pixelNode> explored = new ArrayList<>();

        //Assigning parents as null
        source.parent = null;
        destination.parent = null;

        frontier.add(source);
        source.cost = 0;
        //Node to store current node that is being explored
        pixelNode current;

        //While the frontier does not becomes null
        while (!frontier.isEmpty()){
            //Getting the lowest cost node among all nodes present in frontier
            current = calculationsForAStar.getLowestCostNode(frontier);
            //If destination node is found then backtrack the path
            if(current == destination)
                return calculationsForAStar.backtracking(current);

            //Remove the currently explored node from frontier
            frontier.remove(current);
            //Add that node in explored
            explored.add(current);
            //Generate all the neighbours of the current node and store in an arraylist
            ArrayList<pixelNode> neighbours = findingNeighbours.getNeighbours(current, pixels, terrainMap);
            for (int i = 0; i < neighbours.size(); i++) {    //For every neighbour
                //If node is not in explored
                if(!explored.contains(neighbours.get(i))){
                    //If node is not in frontier
                    double speed = calculationsForAStar.totalSpeed(neighbours.get(i));
                    if(!frontier.contains(neighbours.get(i))){
                        /*
                        Calculating total path cost i.e. f(n) for every node along with its distance,
                        and assigning current node as parent node. Also add this node to frontier
                         */
                        neighbours.get(i).cost = calculationsForAStar.totalPathCost(neighbours.get(i), destination,speed);
                        neighbours.get(i).parent = current;
                        neighbours.get(i).distance += calculationsForAStar.calculateDistance(current, neighbours.get(i));
                        frontier.add(neighbours.get(i));
                    }
                    /*
                    If the node is already in frontier then check if its cost is less than
                    current cost calculated and assign its parent accordingly
                     */
                    else{
                        double cost = calculationsForAStar.totalPathCost(neighbours.get(i), destination,speed);
                        if(cost < neighbours.get(i).cost){
                            neighbours.get(i).cost = cost;
                            //Subtracting previous parent distance
                            neighbours.get(i).distance -= neighbours.get(i).parent.distance;
                            neighbours.get(i).parent = current;
                            //Adding new parent's distance
                            neighbours.get(i).distance += neighbours.get(i).parent.distance;
                        }
                    }
                }
            }
        }
        return null;
    }
}
