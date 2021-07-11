package com.sethip.main.algorithms;

import com.sethip.main.models.Vertex;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchRecursion {

    List<String> results;

    public List<String> getResults() {
        return results;
    }

    public DepthFirstSearchRecursion() {
        results = new ArrayList<>();
    }

    public void traverse(Vertex root) {
        if(root == null) {
            return;
        }
        results.add(root.toString());
        for(Vertex v: root.getNeighbors()) {
            if(!v.isVisited()) {
                v.setVisited(true);
                traverse(v);
            }
        }
    }
}
