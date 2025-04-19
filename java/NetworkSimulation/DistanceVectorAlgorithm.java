/*package NetworkSimulation;

import java.util.*;

class DistanceVectorAlgorithm {
    public void runDistanceVector(List<Router> routers) {
        Map<Router, Map<Router, Integer>> routingTable = new HashMap<>();

        // Initialize the distance table for each router
        for (Router router : routers) {
            Map<Router, Integer> distances = new HashMap<>();
            for (Router r : routers) {
                if (router == r) {
                    distances.put(r, 0); // Distance to itself is 0
                } else {
                    distances.put(r, Integer.MAX_VALUE); // Infinite distance to others initially
                }
            }
            routingTable.put(router, distances);
        }

        // Update routing tables using the distance vector algorithm
        boolean updated = true;
        while (updated) {
            updated = false;
            for (Router router : routers) {
                Map<Router, Integer> distances = routingTable.get(router);
                for (Map.Entry<Router, Integer> neighborEntry : router.getNeighbors().entrySet()) {
                    Router neighbor = neighborEntry.getKey();
                    int neighborDistance = neighborEntry.getValue();
                    Map<Router, Integer> neighborDistances = routingTable.get(neighbor);

                    // Check and update the distances to all routers via the neighbor
                    for (Router dest : routers) {
                        int newDist = neighborDistance + neighborDistances.get(dest);
                        if (newDist < distances.get(dest)) {
                            distances.put(dest, newDist);
                            updated = true;
                        }
                    }
                }
            }
        }

        printRoutingTable(routingTable);
    }

    private void printRoutingTable(Map<Router, Map<Router, Integer>> routingTable) {
        System.out.println("Distance Vector Algorithm Routing Table:");
        for (Router router : routingTable.keySet()) {
            System.out.println("Router " + router.getName() + ":");
            for (Map.Entry<Router, Integer> entry : routingTable.get(router).entrySet()) {
                String distance = (entry.getValue() == Integer.MAX_VALUE) ? "∞" : entry.getValue().toString();
                System.out.println("  -> " + entry.getKey().getName() + ": " + distance);
            }
        }
    }
} */

package NetworkSimulation;

import java.util.*;

class DistanceVectorAlgorithm {
    public void runDistanceVector(List<Router> routers) {
        Map<Router, Map<Router, Integer>> routingTable = new HashMap<>();

        // Initialize the distance table for each router
        for (Router router : routers) {
            Map<Router, Integer> distances = new HashMap<>();
            for (Router r : routers) {
                if (router == r) {
                    distances.put(r, 0); // Distance to itself is 0
                } else if (router.getNeighbors().containsKey(r)) {
                    distances.put(r, router.getNeighbors().get(r)); // Distance to direct neighbors
                } else {
                    distances.put(r, Integer.MAX_VALUE); // Infinite distance to others initially
                }
            }
            routingTable.put(router, distances);
        }

        // Update routing tables using the distance vector algorithm
        boolean updated = true;
        while (updated) {
            updated = false;
            for (Router router : routers) {
                Map<Router, Integer> distances = routingTable.get(router);
                for (Map.Entry<Router, Integer> neighborEntry : router.getNeighbors().entrySet()) {
                    Router neighbor = neighborEntry.getKey();
                    int neighborDistance = neighborEntry.getValue();
                    Map<Router, Integer> neighborDistances = routingTable.get(neighbor);

                    // Check and update the distances to all routers via the neighbor
                    for (Router dest : routers) {
                        if (neighborDistances.get(dest) != Integer.MAX_VALUE) {  // Skip if unreachable
                            int newDist = neighborDistance + neighborDistances.get(dest);
                            if (newDist < distances.get(dest)) {
                                distances.put(dest, newDist);
                                updated = true;
                            }
                        }
                    }
                }
            }
        }

        printRoutingTable(routingTable);
    }

    private void printRoutingTable(Map<Router, Map<Router, Integer>> routingTable) {
        System.out.println("Distance Vector Algorithm Routing Table:");
        for (Router router : routingTable.keySet()) {
            System.out.println("Router " + router.getName() + ":");
            for (Map.Entry<Router, Integer> entry : routingTable.get(router).entrySet()) {
                String distance = (entry.getValue() == Integer.MAX_VALUE) ? "∞" : entry.getValue().toString();
                System.out.println("  -> " + entry.getKey().getName() + ": " + distance);
            }
        }
    }
}

                          


