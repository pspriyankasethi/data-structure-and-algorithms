package com.sethip.test.algorithms;

import com.sethip.main.algorithms.BellmanFord;
import com.sethip.main.models.Edge2;
import com.sethip.main.models.VertexWithEdge2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class BellmanFordTest {
    @Test
    void getShortestPath() {
        VertexWithEdge2 a = new VertexWithEdge2("A"),
                b = new VertexWithEdge2("B"),
                c = new VertexWithEdge2("C"),
                e = new VertexWithEdge2("E"),
                f = new VertexWithEdge2("F"),
                h = new VertexWithEdge2("H");

        Edge2 ab = new Edge2(a, b, 5),
                ae = new Edge2(a, e, 9),
                ah = new Edge2(a, h, 8),

                bc = new Edge2(b, c, 12),
                bh = new Edge2(b, h, 4),

                ef = new Edge2(e, f, 4),
                eh = new Edge2(e, h, 5),

                fc = new Edge2(f, c, 1),

                hc = new Edge2(h, c, 7),
                hf = new Edge2(h, f, 6);

        List<VertexWithEdge2> graph = new ArrayList<>();
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(e);
        graph.add(f);
        graph.add(h);

        List<Edge2> edge2List = new ArrayList<>();
        edge2List.add(ab);
        edge2List.add(ae);
        edge2List.add(ah);
        edge2List.add(bc);
        edge2List.add(bh);
        edge2List.add(ef);
        edge2List.add(eh);
        edge2List.add(fc);
        edge2List.add(hc);
        edge2List.add(hf);

        BellmanFord bellmanFord = new BellmanFord(graph, edge2List);
        bellmanFord.compute(a);
        System.out.println(c.toString());
        System.out.println(h.toString());
    }
}