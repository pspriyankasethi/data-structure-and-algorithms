package com.sethip.main.models;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    String name;
    boolean visited;
    boolean beingVisited;
    List<Vertex> neighbors;

    public Vertex(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Vertex v) {
        this.neighbors.add(v);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
