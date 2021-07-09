package com.sethip.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    class Vertex {
        String name;
        boolean visited;
        List<Vertex> neighbors;

        Vertex(String name) {
            this.name = name;
            this.neighbors = new LinkedList<>();
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
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
//            return "Vertex{" +
//                    "name='" + name + '\'' +
//                    ", visited=" + visited +
//                    ", neighbors=" + neighbors +
//                    '}';
        }
    }

    public void traverse(Vertex root) {
        Vertex current;
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        root.setVisited(true);
        while(!queue.isEmpty()) {
            current = queue.poll();
            System.out.println(current.toString());
            for(Vertex v: current.neighbors) {
                if(!v.isVisited()) {
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }

    public void run() {
        // Create test case
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

        traverse(a);
    }
}
