package com.sethip.main.algorithms;

import com.sethip.main.models.Vertex;

import java.util.List;

public class CycleDetection {

    boolean isCyclic;
    List<Vertex> graph;

    public boolean isCyclic() {
        return isCyclic;
    }

    public CycleDetection(List<Vertex> graph) {
        this.isCyclic = false;
        this.graph = graph;
        for(Vertex v: graph) {
            if(!v.isVisited() && !this.isCyclic) {
                dfs(v);
            }
        }
    }

    private void dfs(Vertex curr) {
        curr.setBeingVisited(true);
        for(Vertex v: curr.getNeighbors()) {
            if(v.isBeingVisited()) {
                this.isCyclic = true;
                return;
            }
            if(!v.isVisited()) {
                dfs(v);
            }
        }
        curr.setBeingVisited(false);
        curr.setVisited(true);
    }
}
