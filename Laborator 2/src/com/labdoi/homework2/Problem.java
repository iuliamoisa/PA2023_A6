package com.labdoi.homework;
import com.labdoi.compulsory.Location;
import com.labdoi.compulsory.Road;
/**
 * Clasa Problem: describes an instance of the problem.
 *
 * @author Moisa Iulia-Elena
 */
public class Problem {
    private Location[] locations;
    private Road[] roads;
    private boolean[] visited;
    private int[][] adjacencyMatrix;
    public int numberOfLocations = 0, numberOfRoads = 0;

    /**
     * method which adds, if possible, an object in the array
     * adding the same location or road twice is not allowed; equals method used
     * @param object location or road
     */
    public void addLocation(Location object){
        if(numberOfLocations == 0)
            locations = new Location[50];
        for (Location location : locations) {
            if (object.equals(location)) {
                System.out.println("The problem does not allow adding the same location twice!");
                System.exit(-1);
            }
        }
        locations[numberOfLocations] = object;
        numberOfLocations++;
        System.out.println("Location added successfully!");
    }
    public void addRoad(Road object){
        //adauga drumuri in instanta problemei
        if(numberOfRoads== 0)
            roads = new Road[50];
        for (Road road : roads)
            if (object.equals(road)) {
                System.out.println("The problem does not allow adding the same road twice!");
                System.exit(-1);
            }
        roads[numberOfRoads] = object;
        numberOfRoads++;
        System.out.println("Road added successfully!");
    }

    /**
     * method that determines if a problem's instance is valid.
     */
    public void checkInstance(){
        for (int i = 0; i < numberOfLocations - 1; i++)
            for(int j = i+1; j < numberOfLocations; j++)
                if (locations[i].equals(locations[j])) {
                    System.out.println("This instance is not valid! (Problem with locations)");
                    System.exit(-1);
                }

        for(int i = 0; i < numberOfRoads; i++)
            for(int j = i+1; j < numberOfRoads; j++)
                if(roads[i].equals(roads[j])){
                    System.out.println("This instance is not valid!(Problem with roads)");
                    System.exit(-1);
                }
        System.out.println("The problem's instance is valid.");
    }

    /**
     *
     * @param name the name of the location searched for
     * @return the position of the location in the array of locations; -1 if the location doesn't exist
     */
    private int positionOfLocation (String name){
        for (int i = 0; i < numberOfLocations; i++)
            if(name.equals(locations[i].getName()))
                return i;
        return -1;
    }

    /**
     * determine if it is possible to go from one location to another using the given roads.
     * @param i index from where dfs starts
     */
    public void dfs(int i){
        visited[i] = true; // Mark node as "visited"

        for (int j = 0; j < adjacencyMatrix.length; j++)
            if ((adjacencyMatrix[i][j] == 1 || adjacencyMatrix[j][i] == 1) && !visited[j])
                dfs(j); // Visit node
    }

    /**
     * @param start source location
     * @param end destination
     * creates a matrix where: adjacencyMatrix[i][j] = 1, if there is a road between location i and location j
     * @return true, if it is possible to get from A to B; otherwise, false.
     */
    public boolean existsRoadBetweenFirstAndSecond(Location start, Location end) {
        int startIndex, endIndex;
        startIndex = positionOfLocation(start.getName());
        endIndex = positionOfLocation(end.getName());
        adjacencyMatrix = new int[numberOfLocations][numberOfLocations];
        int source, destination;
        for(int i = 0; i < numberOfRoads; i++){
            source = positionOfLocation(roads[i].getFirstLocation().getName());
            destination = positionOfLocation(roads[i].getSecondLocation().getName());
            adjacencyMatrix[source][destination] = adjacencyMatrix[destination][source] = 1;
        }
        visited = new boolean[numberOfLocations];

        dfs(startIndex);
        return visited[endIndex];
    }

}
