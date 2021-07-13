package com.sethip.test.algorithms;

import com.sethip.main.algorithms.TopologicalOrderingDFS;
import com.sethip.main.models.Vertex;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TopologicalOrderingDFSTest {

    @Test
    void compute() {
        List<Vertex> graph = new ArrayList<>();

        Vertex v0 = new Vertex("0"),
                v1 = new Vertex("1"),
                v2 = new Vertex("2"),
                v3 = new Vertex("3"),
                v4 = new Vertex("4"),
                v5 = new Vertex("5");

        v2.addNeighbor(v3);

        v3.addNeighbor(v1);

        v4.addNeighbor(v0);
        v4.addNeighbor(v1);

        v5.addNeighbor(v0);
        v5.addNeighbor(v2);

        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        TopologicalOrderingDFS topologicalOrderingDFS = new TopologicalOrderingDFS();
        topologicalOrderingDFS.compute(graph);

        Stack stack = topologicalOrderingDFS.getStack();
        while(!stack.isEmpty()) {
            Vertex v = (Vertex) stack.pop();
            System.out.print(v + " -> ");
        }
    }
}