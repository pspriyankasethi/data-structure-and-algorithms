package com.sethip.main.models;

public class Edge2 {
    VertexWithEdge2 source;
    VertexWithEdge2 target;
    int weight;

    public Edge2(VertexWithEdge2 source, VertexWithEdge2 target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public VertexWithEdge2 getSource() {
        return source;
    }

    public VertexWithEdge2 getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }
}
