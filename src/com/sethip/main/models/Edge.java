package com.sethip.main.models;

public class Edge {
    VertexWithEdge target;
    int weight;

    public Edge(VertexWithEdge target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public VertexWithEdge getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }
}
