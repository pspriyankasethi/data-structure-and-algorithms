package com.sethip.test.algorithms;

import com.sethip.main.algorithms.BreadthFirstSearch;
import com.sethip.main.models.Vertex;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BreadthFirstSearchTest {
    BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

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

        List<String> expectedResult = new ArrayList<>(Arrays.asList("A", "B", "G", "C", "D", "E", "F"));
        List<String> actualResult = breadthFirstSearch.traverse(a);

        assert actualResult.equals(expectedResult);
    }
}