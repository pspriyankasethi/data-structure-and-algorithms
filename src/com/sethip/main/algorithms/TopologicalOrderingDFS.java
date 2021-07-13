package com.sethip.main.algorithms;

import com.sethip.main.models.Vertex;

import java.util.List;
import java.util.Stack;

public class TopologicalOrderingDFS {

    Stack<Vertex> stack;

    public TopologicalOrderingDFS() {
       stack = new Stack<>();
    }

    public Stack getStack() {
        return this.stack;
    }

    void dfs(Vertex vertex) {
        if(!vertex.isVisited()) {
            vertex.setVisited(true);
            for(Vertex v: vertex.getNeighbors()) {
                dfs(v);
            }
            stack.add(vertex);
        }
    }

    public void compute(List<Vertex> graph) {
        for(int i = 0; i < graph.size(); i++) {
            if(!graph.get(i).isVisited()) {
                dfs(graph.get(i));
            }
        }
    }
}
