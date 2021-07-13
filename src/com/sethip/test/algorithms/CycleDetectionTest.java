package com.sethip.test.algorithms;

import com.sethip.main.algorithms.CycleDetection;
import com.sethip.main.models.Vertex;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CycleDetectionTest {
    @Test
    void isCyclic() {
        List<Vertex> graph = new ArrayList<>();

        Vertex a = new Vertex("a"),
                b = new Vertex("b"),
                c = new Vertex("c"),
                d = new Vertex("d"),
                e = new Vertex("e"),
                f = new Vertex("f");

        a.addNeighbor(c);
        a.addNeighbor(e);

        c.addNeighbor(b);
        c.addNeighbor(d);

        e.addNeighbor(d);

        d.addNeighbor(a);

        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);
        graph.add(f);

        CycleDetection cycleDetection = new CycleDetection(graph);
        assert cycleDetection.isCyclic();
    }
}