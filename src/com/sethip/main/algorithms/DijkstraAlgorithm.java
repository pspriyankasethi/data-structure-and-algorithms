package com.sethip.main.algorithms;

import com.sethip.main.models.Edge;
import com.sethip.main.models.Edge2;
import com.sethip.main.models.VertexWithEdge;
import com.sethip.main.models.VertexWithEdge2;

import java.util.*;

public class DijkstraAlgorithm {
    List<VertexWithEdge2> graph;
    VertexWithEdge2 source, destination;
    Queue<VertexWithEdge2> queue;

    public DijkstraAlgorithm(List<VertexWithEdge2> graph, VertexWithEdge2 source, VertexWithEdge2 destination) {
        this.graph = graph;
        this.source = source;
        this.destination = destination;
        this.queue = new PriorityQueue<>();
    }

    private void compute() {
        VertexWithEdge2 curr;
        // pop queue
        while(!queue.isEmpty()) {
            curr = queue.poll();
            // calculate minimum distance of neighbors
            for(Edge2 e: curr.getNeighbors()) {
                int dist = curr.getMinDistance() + e.getWeight();
                if (dist < e.getTarget().getMinDistance()) {
                    e.getTarget().setMinDistance(dist);
                    e.getTarget().setPredecessor(curr);
                }
                // push in queue
                this.queue.add(e.getTarget());
            }
        }
    }

    public ArrayList<VertexWithEdge2> getShortestPath() {
        this.source.setMinDistance(0);
        this.queue.add(this.source);
        compute();
        for(VertexWithEdge2 v: this.graph) {
            System.out.println(v + " " + v.getMinDistance());
        }
        ArrayList<VertexWithEdge2> shortestPath = new ArrayList<>();
        if(this.destination.getMinDistance() != Integer.MAX_VALUE){
            VertexWithEdge2 curr = this.destination;
            while (curr != null) {
                shortestPath.add(curr);
                curr = curr.getPredecessor();
            }
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
