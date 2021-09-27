In this project, I have build a map which have optimal path for orienteering during different seasons. Considering the elevation contours and speeds on different
terrains, I have build the map using A* algorithm.

- main function - Initially, I have processed every input file i.e. elevation file,
path file and stored into respective data structures. Also, terrain image file
is saved into data structure where terrain of each pixel is saved. Then a
terrainMap is created that creates node for each pixel and information of
each pixel such as its x and y axis, terrain, elevation, speed = speed based on
the type of terrain , distance = distance from start node to this pixel and
total cost is saved.


For every two points in the path file considered as source and destination
respectively, I execute A* algorithm -

- aStar (A*) - In this function first I am checking if the source and destination
nodes are not in out of bound regions i.e. terrains (like water, Impassible
Vegetation and Out of Bounds) whose speed is less than 0. If yes, then
return null. There are two arraylist 'frontier' and 'explored' which save
nodes to be explored and nodes that have been explored already
respectively. Initially source node is added in frontier and cost of source
node is 0. Also the parents of source and destination nodes are assigned as
null. Now, the while loop is run until there are elements in frontier list :
  - From the frontier list find a node that have the lowest cost using
getLowestCostNode (discussed ahead) and assign that node as the current node
which is to be explored now. If the current node is the destination (goal) node
then backtrack (discussed ahead) this node to find a path. Else remove current
node from the frontier list and add in explored list. This means that this node has
been explored. Now, I am finding all the neighbours (discussed ahead) of the
current node. For every neighbour node, I am checking if this node exists in the
explored list. If it is the continue to the next neighbour node. Else, check if the
neighbour exists in the frontier node. If it does not exist, then find the speed using
totalSpeed function (discussed ahead), calculate the total cost i.e. f(n) using
totalPathCost function (discussed further), calculate total distance using
calculateDistance function (discussed further). Now I am adding this node in
frontier list. If the element already exists in frontier than I am checking if the cost
calculated for the node right now if less than the cost that the code already had. If
the current cost is less than cost of node = current cost. Also the parent node of
this neighbour is changed to current node. If the optimal path is found then it is
returned, else return null.
- getLowestCostNode - This function finds the node that have lowest cost
from the frontier Arraylist. This function take frontier list as parameter. All
elements of frontier are copied into a Queue(aQueue), a new
node(lowCostNode) is made with value as null initially, and a
variable(lowCost) keep tracks of the lowest cost found till now with initial
value as infinite. Running while loop till the queue is empty - check if the
node popped from queue has low cost than the cost present in lowCost
variable. If yes, then the lowCost = cost of the popped node and
lowCostNode = node popped. This function returns the node with lowest
cost.
- backtracking - This function backtracks the goal node that is found to trace
and store the path. The goal node is passed as parameter in this function
and until the current.parent is not null I keep on adding the x and y values
of the current node in an Arraylist. After adding the value current node is
equal to current.parent. This function returns the path that we have traced
- getNeighbours - This function finds all the neighbours of the node that is
provided as a parameter. In this function, I am first storing values of x axis
and y axis in two variables. An Arraylist(neighbours) is made to store all the
neighbours generated. Considering the location of the x and y axis the
neighbouring nodes are generated. That is if (x,y) lies in any of the four
corners then only 3 neighbours are generated based on which corner, if
(x,y) lies on the border of the image then 5 neighbours are generated based
on which border, else if (x,y) lies somewhere in the middle then 8
neighbours are generated based on their position.
- totalPathCost - This function calculates the total cost i.e. f(n) basen on
which the node with lowest value will be selected to explore. This function
returns the heuristic value of each node.
- calculateHeuristic - This function calculates the heuristic value i.e. h(n) for
each pixel or node. In this function I am calculating the distance from the
source node (which is one of neighbour) to the destination node (final node
till which we want to find path). This is done by using euclidean distance
and elevation i.e. the distance is Square root (Square of (source.x -
destination.x) + Square of (source.y - destination.y) + Square of
(source.elevation - destination.elevation)). Further I am dividing the
distance obtained with the speed of source node + speed of source node
parent + speed of destination node. In this heuristic I have considered
elevation points, speed and distance of source node and destination node
and hence the value obtained will be very efficient to determine the lowest
cost node. Further this value obtained roughly calculates the average time
which will be always less than the actual distance from the source and
destination considering the elevation and speed on each type of terrain.
Thus, this heuristic provides an efficient value to find optimal path using A*.
- calculateDistance - This function calculates the actual distance from a
source node (i.e. current node that is being explored) to destination node
(i.e. neighbour of source node). The distance from one pixel to another is - If
x axis of both nodes is same then longitude value is considered i.e. 10.29; If
y axis of both nodes is same then latitude value is considered i.e. 7.55; Else,
Square root of (Square of 10.29 + Square of 7.55) is considered. Now, the
total distance is the distance from one pixel to another + distance of source
node's parent. This distance is efficient to find the total path covered from
the starting pixel to this pixel as this value considers the distance of its
parent node as well.
- drawImage - This image draws the path obtained. From the main function I
have called this function for every path that is obtained. Path is given as the
parameter for this function. I have used java ImageIO class and Java Color
class to draw the image. The terrain image file in opened and read using
ImageIO.read function and is stored in BufferedImage object. For every
pixel that is part of the path is coloured as red. So these pixel's RGB value is
updated in temp array as 255/0/0 (RBG value of red colour). Now the RGB
value of every pixel in temp array is stored in red, green and blue variables
respectively. Using the setRGB function the pixel value is updated in the
image. Now the output file is opened and the updated image is
saved/written to this output file using ImageIO.write function.


For different seasons :
- Summer - The summer has the same process or same way to find optimal
path as described above.
- Fall - In the fall season as the leaves fall from tree so the speed of the easy
movement forest reduces and this change has been made in the main
function where the speed is 9.5 in fall; otherwise 11.
- Winter - In the winter season 7 pixels from the water pixel is considered as
snow area. So the speed of the snow is considered in this season which is
assigned in the main function. The path is obtained in the same way as it is
found in summer season. But for drawing image for this season I have wrote
a function called winterImage. In winterImage function I have declared a
boolean variable which determines if there is land pixel beside water pixel.
For every pixel determine if that pixel is water pixel. If it is water pixel, then
I am finding if there is any neighbouring land pixel then isLand is true. For 7
consecutive neighbouring pixels - if the neighbouring pixel is a land pixel
then change the colour of the pixel to the snow colour. So the RGB value of
the pixel is updates in both pixels and temp array.
- Spring - In spring season any pixel within 15 pixels of water 15 is called as a
mud water. Also any pixel from these 15 pixel has elevation less than 1 then
it is considered as under water. In springImage function I have used the
same concept as that in the winterImage function but in this the additional
property is that if the elevation of current neighbouring pixel - elevation of
the water pixel is less than 1 then it is considered as underwater and hence
these pixels are coloured as brown.
