package NetworkSimulation;

import java.util.*;

class LinkStateAlgorithm {
    public void runLinkState(List<Router> routers) {
        for (Router source : routers) {
            Map<Router, Integer> distances = new HashMap<>();
            Set<Router> visited = new HashSet<>();
            PriorityQueue<Router> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

            // Initialize distances
            for (Router router : routers) {
                distances.put(router, router == source ? 0 : Integer.MAX_VALUE);
            }

            pq.add(source);

            while (!pq.isEmpty()) {
                Router current = pq.poll();
                visited.add(current);

                // Update distances for neighbors
                for (Map.Entry<Router, Integer> neighborEntry : current.getNeighbors().entrySet()) {
                    Router neighbor = neighborEntry.getKey();
                    int distance = neighborEntry.getValue();

                    if (!visited.contains(neighbor) && distances.get(current) + distance < distances.get(neighbor)) {
                        distances.put(neighbor, distances.get(current) + distance);
                        pq.add(neighbor);
                    }
                }
            }

            printShortestPaths(source, distances);
        }
    }

    private void printShortestPaths(Router source, Map<Router, Integer> distances) {
        System.out.println("Link State Algorithm Shortest Paths from Router " + source.getName() + ":");
        for (Map.Entry<Router, Integer> entry : distances.entrySet()) {
            String distance = (entry.getValue() == Integer.MAX_VALUE) ? "∞" : entry.getValue().toString();
            System.out.println("  -> " + entry.getKey().getName() + ": " + distance);
        }
    }
}

