package com.sethip.test.algorithms;

import com.sethip.main.algorithms.TopologicalOrderingWithEdgeWeight;
import com.sethip.main.models.Edge;
import com.sethip.main.models.VertexWithEdge;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TopologicalOrderingWithEdgeWeightTest {
    @Test
    void getStack() {
        List<VertexWithEdge> graph = new ArrayList<>();

        VertexWithEdge src = new VertexWithEdge("S"),
                a = new VertexWithEdge("A"),
                b = new VertexWithEdge("B"),
                c = new VertexWithEdge("C"),
                d = new VertexWithEdge("D"),
                e = new VertexWithEdge("E");

        src.addNeighbor(new Edge(a, 1));
        src.addNeighbor(new Edge(c, 2));

        a.addNeighbor(new Edge(b, 6));

        b.addNeighbor(new Edge(d, 1));
        b.addNeighbor(new Edge(e, 2));

        c.addNeighbor(new Edge(d, 4));
        c.addNeighbor(new Edge(d, 3));

        d.addNeighbor(new Edge(e, 1));

        graph.add(src);
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);

        TopologicalOrderingWithEdgeWeight topologicalOrderingWithEdgeWeight =
                new TopologicalOrderingWithEdgeWeight(graph);
        Stack topologicalOrder = topologicalOrderingWithEdgeWeight.getStack();
        System.out.println(topologicalOrder);
    }
}