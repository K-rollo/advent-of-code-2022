package day12_hill_climbing.graph;


import day12_hill_climbing.map.MapTransformationManager;
import day12_hill_climbing.map.NodeOnMap;
import day12_hill_climbing.map.Status;

import java.util.*;

import static day12_hill_climbing.Main.PATH;

public class GraphManager {
    List<NodeOnMap> nodes = new ArrayList<>();
    private int nodeNumber = 0;
    NodeOnMap startPoint;
    NodeOnMap endPoint;
    NodeOnMap currentNode;
    private int maxHeight = 0;
    private int dimentionX;
    private int dimentionY;

    MapTransformationManager mapTransformationManager = new MapTransformationManager(PATH);

    public List<NodeOnMap> getNodes() {
        var matrixOfLocationHeigts = mapTransformationManager.getMatrixOfLocationHeights();
        dimentionX = matrixOfLocationHeigts[0].length;
        dimentionY = matrixOfLocationHeigts.length;

        for (int i = dimentionY - 1; i >= 0; i--) {
            for (int j = 0; j < dimentionX; j++) {

                currentNode = new NodeOnMap(nodeNumber, j, dimentionY - 1 - i, matrixOfLocationHeigts[i][j]);

                if (currentNode.height() == 0) startPoint = currentNode;
                if (currentNode.height() > maxHeight) {
                    maxHeight = currentNode.height();
                    endPoint = currentNode;
                }
                nodeNumber++;
                nodes.add(currentNode);
            }
        }
        return nodes;
    }

    public void fillAdjoiningNodes() {
        for (NodeOnMap node : nodes) {

            int currentNodeX = node.x();
            int currentNodeY = node.y();

            if (currentNodeY > 0) {
                var nodeDown = findNodeByXY(currentNodeX, currentNodeY - 1);
                if (nodeDown.height() <= node.height() + 1) node.getAdjoiningNodesList().add(nodeDown);
            }
            if (currentNodeX > 0) {
                var nodeLeft = findNodeByXY(currentNodeX - 1, currentNodeY);
                if (nodeLeft.height() <= node.height() + 1) node.getAdjoiningNodesList().add(nodeLeft);
            }
            if (currentNodeX < dimentionX) {
                var nodeRight = findNodeByXY(currentNodeX + 1, currentNodeY);
                if (nodeRight.height() <= node.height() + 1) node.getAdjoiningNodesList().add(nodeRight);
            }
            if (currentNodeY < dimentionY) {
                var nodeUp = findNodeByXY(currentNodeX, currentNodeY + 1);
                if (nodeUp.height() <= node.height() + 1) node.getAdjoiningNodesList().add(nodeUp);
            }

        }
    }

    NodeOnMap findNodeByXY(int x, int y) {
        return nodes.stream()
                .filter(nd -> nd.x() == x)
                .filter(nd -> nd.y() == y)
                .findFirst().orElse(new NodeOnMap(0, 0, 0, 0));

    }


    public void breadthFirstTraversal() {
        Queue<NodeOnMap> queue = new LinkedList<>();
        queue.add(startPoint);
        startPoint.setStatus(Status.VISITED);
        while (!queue.isEmpty()) {
            NodeOnMap currentNode = queue.poll();
            for (NodeOnMap node : currentNode.getAdjoiningNodesList()) {
                if (!node.getStatus().equals(Status.VISITED)) {
                    node.setStatus(Status.VISITED);
                    node.setPathToGetThisNode(currentNode.getPathToGetThisNode(), currentNode);
                    queue.add(node);
                }
            }
        }
    }

    public int getShortestPathFromLowestElevation() {
        List<Integer> steps = new ArrayList<>();
        int shortestAmountOfMoves = nodes.size();

        getNodes(); // clears status
        findNodeByXY(0, 20).updateHeight(1);

        for (NodeOnMap node : nodes) {
            if (node.height() == 1) {
                for (NodeOnMap nodeToClear : nodes) {
                    nodeToClear.setStatus(Status.NOT_VISITED);
                    nodeToClear.clearPathToGetThisNode();
                }
                startPoint = node;
                breadthFirstTraversal();
                if ( (endPoint.getPathToGetThisNode().size() < shortestAmountOfMoves)  && (endPoint.getPathToGetThisNode().size() > 0) ){
                    shortestAmountOfMoves = endPoint.getPathToGetThisNode().size();
                }
 //               int stepsToTheTopFromStartPoint = endPoint.getPathToGetThisNode().size();
//                steps.add(stepsToTheTopFromStartPoint);
            }
        }
        return shortestAmountOfMoves;
    }
}
