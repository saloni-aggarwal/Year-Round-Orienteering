/**
 * This class is a node for each pixel in the image. It contains information of
 * each pixel such as its x and y axis, terrain, speed on terrain, distance from
 * starting point, and cost.
 */
public class pixelNode {
    pixelNode parent;   //Parent node of a particular node
    //x and y axis
    int x;
    int y;
    String terrain;    //Type of terrain
    double elevation;    //Elevation on this pixel
    float speed;    //Speed for this terrain
    double distance;    //Distance covered so far from starting point
    double cost;    //Cost of the node

    /**
     * Parameterized constructor of pixelNode class
     * @param x    x axis
     * @param y    y axis
     */
    public pixelNode(int x, int y) {
        this.parent = null;
        this.x = x;
        this.y = y;
        this.terrain = null;
        this.elevation = 0.0;
        this.speed = 0.0f;
        double distance = 0;
        this.cost = Double.POSITIVE_INFINITY;  //Initially assigned as infinity
    }
}
