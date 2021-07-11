package com.sethip.main.algorithms;

import com.sethip.main.models.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchIteration {
    Stack<Vertex> stack;

    public DepthFirstSearchIteration() {
        this.stack = new Stack<>();
    }

    public List<String> traverse(Vertex root) {
        Vertex temp;
        stack.push(root);
        root.setVisited(true);
        List<String> results = new ArrayList<>();
        while(!stack.isEmpty()) {
            temp = stack.pop();
            results.add(temp.toString());
            for(Vertex v: temp.getNeighbors()) {
                if(!v.isVisited()) {
                    v.setVisited(true);
                    stack.push(v);
                }
            }
        }
        return results;
    }
}
