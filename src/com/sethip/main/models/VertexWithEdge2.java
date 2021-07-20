package com.sethip.main.models;

import java.util.ArrayList;
import java.util.List;

public class VertexWithEdge2 implements Comparable {
    String name;
    boolean visited;
    int minDistance;
    VertexWithEdge2 predecessor;
    List<Edge2> neighbors;

    public VertexWithEdge2(String name) {
        this.name = name;
        this.minDistance = Integer.MAX_VALUE;
        this.neighbors = new ArrayList<>();
    }

    public String getName() { return this.name; }

    public int getMinDistance() {
        return this.minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public VertexWithEdge2 getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(VertexWithEdge2 predecessor) {
        this.predecessor = predecessor;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Edge2> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Edge2 edge) {
        this.neighbors.add(edge);
    }

    @Override
    public String toString() {
        return this.name + "(" + this.minDistance + ") - " + this.predecessor;
    }

    @Override
    public int compareTo(Object o) {
        return minDistance > ((VertexWithEdge2) o).getMinDistance()? 1 : -1;
    }
}
