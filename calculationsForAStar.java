import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class calculationsForAStar {
    /**
     * This function calculates the heuristics i.e. h(n)
     *
     * @param source         starting node
     * @param destination    destination node
     * @return               heuristic value
     */
    public static double calculateHeuristic(pixelNode source, pixelNode destination, double speed){
        //Calculating heuristic
        double distance = (Math.sqrt(Math.pow((source.x - destination.x),2) +
                Math.pow((source.y - destination.y),2) +
                Math.pow((source.elevation - destination.elevation),2)))/2;
        //Calculating average speed
        double avgSpeed = (source.speed + destination.speed)/2;
        return distance/avgSpeed;
    }

    /**
     *This path calculates the total distance i.e. g(n) from source to destination
     * considering the speed as well
     *
     * @param source         start node
     * @param destination    destination node
     * @return               distance from start to destination
     */
    public static double calculateDistance(pixelNode source, pixelNode destination){
        //Calculating distance
        double distance;
        if(source.x == destination.x)
            distance = 10.29;
        else if(source.y == destination.y)
            distance = 7.55;
        else
            distance = Math.sqrt(Math.pow(10.29,2) + Math.pow(7.55,2));
        //Including the distance of parent node as well
        if(source.parent != null)
            distance += source.parent.distance;
        return distance;
    }

    public static double totalSpeed(pixelNode source){
        double speed = source.speed;
        if(source.parent != null)
            speed += source.parent.speed;
        return speed;
    }

    /**
     * Calculating total cost i.e. f(n)
     *
     * @param neighbour       neighbouring node
     * @param destination     destination node
     * @return                total cost
     */
    public static double totalPathCost(pixelNode neighbour, pixelNode destination, double speed){
        return calculateHeuristic(neighbour, destination, speed);
    }

    /**
     * This function finds the node with lowest cost from the frontier list
     *
     * @param frontier    List of nodes
     * @return            Node with lowest cost
     */
    public static pixelNode getLowestCostNode(ArrayList<pixelNode> frontier){
        //Queue to save all the elements of frontier list
        Queue<pixelNode> aQueue = new LinkedList<>(frontier);
        //Stores node with lowest code
        pixelNode lowCostNode = null;
        //Stores lowest cost
        double lowCost = Double.POSITIVE_INFINITY;
        //Finding nodes
        while (!aQueue.isEmpty()){
            pixelNode node = aQueue.remove();
            if(node.cost < lowCost){
                lowCostNode = node;
                lowCost = node.cost;
            }
        }
        return lowCostNode;
    }

    /**
     * This function backtracks the goal node to find the path
     *
     * @param current    goal node
     * @return           path from source to destination
     */
    public static  ArrayList<Integer> backtracking(pixelNode current){
        //List to store path
        ArrayList<Integer> path = new ArrayList<>();
        while (current.parent != null){
            path.add(current.x);
            path.add(current.y);
            current = current.parent;
        }
        path.add(current.x);
        path.add(current.y);
        return path;
    }
}
