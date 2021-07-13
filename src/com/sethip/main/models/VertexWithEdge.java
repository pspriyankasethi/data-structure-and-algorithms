package com.sethip.main.models;

import java.util.ArrayList;
import java.util.List;

public class VertexWithEdge {
    String name;
    boolean visited;
    int minDistance;
    VertexWithEdge predecessor;
    List<Edge> neighbors;

    public VertexWithEdge(String name) {
        this.name = name;
        this.minDistance = Integer.MAX_VALUE;
        this.neighbors = new ArrayList<>();
    }

    public int getMinDistance() {
        return this.minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public VertexWithEdge getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(VertexWithEdge predecessor) {
        this.predecessor = predecessor;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Edge> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Edge edge) {
        this.neighbors.add(edge);
    }

    @Override
    public String toString() {
        return this.name + " - " + this.predecessor;
    }
}
