package day12_hill_climbing.map;

import java.util.ArrayList;
import java.util.List;

public class NodeOnMap {

    private final int number;
    private final int x;
    private final int y;
    private int height;
    private List<NodeOnMap> adjoiningNodesList = new ArrayList<>();
    private List<NodeOnMap> pathToGetThisNode = new ArrayList<>();

    private Status status = Status.NOT_VISITED;

    public NodeOnMap(int number, int x, int y, int height) {
        this.number = number;
        this.x = x;
        this.y = y;
        this.height = height;
    }

    double getDistanceToTop(int topX, int topY) {
        return Math.sqrt((double) (topX * topX) + (double) (topY * topY));
    }

    ;


    public int number() {
        return number;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public int height() {
        return height;
    }

    public void updateHeight(int newHeight) {
        this.height = newHeight;
    }

    public List<NodeOnMap> getAdjoiningNodesList() {
        return adjoiningNodesList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<NodeOnMap> getPathToGetThisNode() {
        return pathToGetThisNode;
    }
    public void clearPathToGetThisNode(){
        pathToGetThisNode.clear();
    }

    public void setPathToGetThisNode(List<NodeOnMap> pathToPreviousNode, NodeOnMap previousNode) {
        pathToGetThisNode.addAll(pathToPreviousNode);
        pathToGetThisNode.add(previousNode);
    }
}
