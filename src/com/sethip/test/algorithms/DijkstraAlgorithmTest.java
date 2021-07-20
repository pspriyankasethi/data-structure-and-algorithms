package com.sethip.test.algorithms;

import com.sethip.main.algorithms.DijkstraAlgorithm;
import com.sethip.main.models.Edge;
import com.sethip.main.models.Edge2;
import com.sethip.main.models.VertexWithEdge;
import com.sethip.main.models.VertexWithEdge2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraAlgorithmTest {
    @Test
    void findShortestPath() {
        VertexWithEdge2 a = new VertexWithEdge2("A"),
                b = new VertexWithEdge2("B"),
                c = new VertexWithEdge2("C"),
                d = new VertexWithEdge2("D"),
                e = new VertexWithEdge2("E"),
                f = new VertexWithEdge2("F"),
                g = new VertexWithEdge2("G"),
                h = new VertexWithEdge2("H");

        a.addNeighbor(new Edge2(a, b, 5));
        a.addNeighbor(new Edge2(a, e, 9));
        a.addNeighbor(new Edge2(a, h, 8));

        b.addNeighbor(new Edge2(b, c, 12));
        b.addNeighbor(new Edge2(b, d, 15));
        b.addNeighbor(new Edge2(b, h, 4));

        c.addNeighbor(new Edge2(c, d, 3));
        c.addNeighbor(new Edge2(c, g, 11));

        d.addNeighbor(new Edge2(d, g, 9));

        e.addNeighbor(new Edge2(e, f, 4));
        e.addNeighbor(new Edge2(e, g, 20));
        e.addNeighbor(new Edge2(e, h, 5));

        f.addNeighbor(new Edge2(f, c, 1));
        f.addNeighbor(new Edge2(f, g, 13));

        h.addNeighbor(new Edge2(h, c, 7));
        h.addNeighbor(new Edge2(h, f, 6));

        List<VertexWithEdge2> graph = new ArrayList<>();
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);
        graph.add(f);
        graph.add(g);
        graph.add(h);

        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graph, a, g);

        ArrayList<VertexWithEdge2> shortestPath = dijkstraAlgorithm.getShortestPath();
        System.out.println("===========================");
        for(VertexWithEdge2 v: shortestPath) {
            System.out.print(v.getName() + " -> ");
        }
    }
}