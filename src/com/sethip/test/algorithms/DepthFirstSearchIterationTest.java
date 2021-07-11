package com.sethip.test.algorithms;

import com.sethip.main.algorithms.DepthFirstSearchIteration;
import com.sethip.main.models.Vertex;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DepthFirstSearchIterationTest {
    DepthFirstSearchIteration depthFirstSearch = new DepthFirstSearchIteration();

    @Test
    void traverse() {
        Vertex a = new Vertex("A"),
                b = new Vertex("B"),
                c = new Vertex("C"),
                d = new Vertex("D"),
                e = new Vertex("E"),
                f = new Vertex("F"),
                g = new Vertex("G");

        // Connect
        a.addNeighbor(b);
        a.addNeighbor(g);

        b.addNeighbor(c);
        b.addNeighbor(d);
        b.addNeighbor(e);

        c.addNeighbor(d);

        e.addNeighbor(f);

        f.addNeighbor(c);
        f.addNeighbor(g);

        g.addNeighbor(d);

        List<String> expectedResult = new ArrayList<>(Arrays.asList("A", "G", "D", "B", "E", "F", "C"));
        List<String> actualResult = depthFirstSearch.traverse(a);

        assert actualResult.equals(expectedResult);
    }
}