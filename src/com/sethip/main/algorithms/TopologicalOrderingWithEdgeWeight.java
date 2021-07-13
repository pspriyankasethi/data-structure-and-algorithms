package com.sethip.main.algorithms;

import com.sethip.main.models.Edge;
import com.sethip.main.models.VertexWithEdge;

import java.util.List;
import java.util.Stack;

public class TopologicalOrderingWithEdgeWeight {
    List<VertexWithEdge> graph;
    Stack<VertexWithEdge> stack;

    public Stack<VertexWithEdge> getStack() {
        return this.stack;
    }

    public TopologicalOrderingWithEdgeWeight(List<VertexWithEdge> graph) {
        this.graph = graph;
        this.stack = new Stack<>();
        for(VertexWithEdge vertex: graph) {
            if(!vertex.isVisited()) {
                dfs(vertex);
            }
        }
    }

    private void dfs(VertexWithEdge u) {
        u.setVisited(true);
        for(Edge v: u.getNeighbors()) {
            if(!v.getTarget().isVisited()) {
                dfs(v.getTarget());
            }
        }
        stack.add(u);
    }
}
