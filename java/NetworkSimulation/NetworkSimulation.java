package NetworkSimulation;

import java.util.*;

public class NetworkSimulation {
    public static void main(String[] args) {
        // Create routers
        Router router1 = new Router("R1");
        Router router2 = new Router("R2");
        Router router3 = new Router("R3");
        Router router4 = new Router("R4");

        // Create switches
        Switch switch1 = new Switch("S1");
        Switch switch2 = new Switch("S2");

        // Connect routers through switches
        switch1.connectRouter(router1);
        switch1.connectRouter(router2);
        switch2.connectRouter(router2);
        switch2.connectRouter(router3);
        router1.addNeighbor(router2, 2);
        router1.addNeighbor(router3, 4);
        router2.addNeighbor(router4, 1);
        router3.addNeighbor(router4, 5);
        router4.addNeighbor(router1, 7);

        List<Router> routers = Arrays.asList(router1, router2, router3, router4);

        // Run Distance Vector Algorithm
        DistanceVectorAlgorithm dv = new DistanceVectorAlgorithm();
        dv.runDistanceVector(routers);

        System.out.println(); // For spacing between outputs

        // Run Link State Algorithm
        LinkStateAlgorithm ls = new LinkStateAlgorithm();
        ls.runLinkState(routers);
    }
}

//javac NetworkSimulation/*.java

//java NetworkSimulation.NetworkSimulation