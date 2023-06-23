package day12_hill_climbing.graph;

import day12_hill_climbing.map.NodeOnMap;

import java.util.ArrayList;
import java.util.List;

public class ConnectionsManager {

    private final List<NodeOnMap> nodes;
    private final List<NodesConnection> connections = new ArrayList<>();

    public ConnectionsManager(List<NodeOnMap> nodes) {
        this.nodes = nodes;
    }

    public List<NodesConnection> getConnections(){

        for (NodeOnMap node : nodes) {
            int startPoint = node.number();
            var adjoiningNodes = node.getAdjoiningNodesList();
            for (NodeOnMap adjNode : adjoiningNodes) {
                connections.add(new NodesConnection(startPoint, adjNode.number()));
            }
        }
        return connections;
    }
}
