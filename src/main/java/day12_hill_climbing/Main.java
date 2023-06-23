package day12_hill_climbing;

import day12_hill_climbing.graph.GraphManager;

public class Main {
    public final static String PATH = "src/main/resources/day-12-input.txt";

    public static void main(String[] args) {

        GraphManager graphManager = new GraphManager();
        var nodes = graphManager.getNodes();
        graphManager.fillAdjoiningNodes();

 //       graphManager.breadthFirstTraversal();
        System.out.println(nodes.get(1928).getPathToGetThisNode().size());

        var steps = graphManager.getShortestPathFromLowestElevation();
        System.out.println(steps);

    }
}
