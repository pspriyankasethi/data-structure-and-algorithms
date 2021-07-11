package com.sethip.main.algorithms;

import com.sethip.main.models.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public List<String> traverse(Vertex root) {
        Vertex current;
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        root.setVisited(true);
        List<String> results = new ArrayList<>();
        while(!queue.isEmpty()) {
            current = queue.poll();
            results.add(current.toString());
            for(Vertex v: current.getNeighbors()) {
                if(!v.isVisited()) {
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
        return results;
    }
}
