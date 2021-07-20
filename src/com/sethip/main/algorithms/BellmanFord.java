package com.sethip.main.algorithms;

import com.sethip.main.models.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BellmanFord {

    List<VertexWithEdge2> vertexList;
    List<Edge2> edgeList;

    public BellmanFord(List<VertexWithEdge2> vertexList, List<Edge2> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }

    public void compute(VertexWithEdge2 source) {
        source.setMinDistance(0);
        for(int i = 0; i < vertexList.size()-1; i++) {
            for(Edge2 e: edgeList) {
                // Relaxation
                VertexWithEdge2 u = e.getSource();
                if(u.getMinDistance() == Integer.MAX_VALUE) continue;
                VertexWithEdge2 v = e.getTarget();
                int dist = u.getMinDistance() + e.getWeight();
                if(dist < v.getMinDistance()) {
                    v.setMinDistance(dist);
                    v.setPredecessor(u);
                }
            }
        }
        for(Edge2 e: edgeList) {
            if(e.getSource().getMinDistance() != Integer.MAX_VALUE &&
                    e.getSource().getMinDistance() + e.getWeight() < e.getSource().getMinDistance()) {
                System.out.println("Negative Cyclic Detected!");
                break;
            }
        }
    }
}
