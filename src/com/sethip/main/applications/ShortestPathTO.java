package com.sethip.main.applications;

import com.sethip.main.algorithms.TopologicalOrderingWithEdgeWeight;
import com.sethip.main.models.Edge;
import com.sethip.main.models.VertexWithEdge;

import java.util.List;
import java.util.Stack;

public class ShortestPathTO {

    List<VertexWithEdge> graph;
    Stack<VertexWithEdge> topologicalOrder;

    public Stack<VertexWithEdge> getTopologicalOrder() {
        return topologicalOrder;
    }

    public ShortestPathTO(List<VertexWithEdge> graph) {
        this.graph = graph;
        TopologicalOrderingWithEdgeWeight topologicalOrderingWithEdgeWeight =
                new TopologicalOrderingWithEdgeWeight(graph);
        this.topologicalOrder = topologicalOrderingWithEdgeWeight.getStack();
    }

    public void compute() {
        graph.get(0).setMinDistance(0);
        while(!topologicalOrder.isEmpty()) {
            VertexWithEdge u = topologicalOrder.pop();
            for(Edge e: u.getNeighbors()) {
                VertexWithEdge v = e.getTarget();
                int distance = u.getMinDistance() + e.getWeight();
                if(distance < v.getMinDistance()) {
                    v.setMinDistance(distance);
                    v.setPredecessor(u);
                }
            }
        }
    }
}
