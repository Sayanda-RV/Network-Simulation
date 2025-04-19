package NetworkSimulation;

import java.util.*;

class Router {
    private String name;
    private Map<Router, Integer> neighbors;

    public Router(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addNeighbor(Router neighbor, int distance) {
        neighbors.put(neighbor, distance);
    }

    public Map<Router, Integer> getNeighbors() {
        return neighbors;
    }
}

