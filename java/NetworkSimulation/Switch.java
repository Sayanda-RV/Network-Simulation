package NetworkSimulation;

import java.util.*;

class Switch {
    private String name;
    private List<Router> connectedRouters;

    public Switch(String name) {
        this.name = name;
        this.connectedRouters = new ArrayList<>();
    }

    public void connectRouter(Router router) {
        connectedRouters.add(router);
    }

    public List<Router> getConnectedRouters() {
        return connectedRouters;
    }

    // Method to get the name of the switch
    public String getName() {
        return name;
    }

    // Optional: Method to display connected routers
    public void printConnectedRouters() {
        System.out.println("Switch " + name + " is connected to:");
        for (Router router : connectedRouters) {
            System.out.println("  Router " + router.getName());
        }
    }
}


