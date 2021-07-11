package com.sethip.main.applications;

import com.sethip.main.models.Pair;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Implement an algorithm that can find the way out of a maze.

[
[1,1,1,1,1],
[1,2,0,1,1],
[1,1,0,1,1],
[1,1,0,0,0],
[1,1,1,1,3],
]
So we have a map like this:
integer 1 represents walls
integer 2 is the starting point
integer 3 is the destination (so this is what we are looking for)
integer 0 represents the states we can consider (so the solution contains one or more 0 states)

So the solution should be something like this (S represents the states in the solution set):

[
[-,-,-,-,-],
[-,2,S,-,-],
[-,-,S,-,-],
[-,-,S,S,S],
[-,-,-,-,3],
]
Good luck!
*/

public class MazeSolverDFS {
    int[][] maze;
    int totalRows, totalCols;
    Pair<Integer, Integer> destination;
    char[][] escapeRoute;
    boolean[][] visited;

    public char[][] getEscapeRoute() {
        return this.escapeRoute;
    }

    public MazeSolverDFS(int[][] maze, Pair<Integer, Integer> destination) {
        this.maze = maze;
        this.totalRows = maze.length;
        this.totalCols = maze[0].length;
        this.destination = destination;
        this.escapeRoute = new char[totalRows][totalCols];
        for(int i = 0; i < totalRows; i++) {
            Arrays.fill(this.escapeRoute[i], '-');
        }
        this.visited = new boolean[totalRows][totalCols];
    }

    private boolean isFeasible(Pair<Integer, Integer> pos) {
        if((pos.getI() < 0 || pos.getI() >= totalRows) ||
                (pos.getJ() < 0 || pos.getJ() >= totalCols) ||
                maze[pos.getI()][pos.getJ()] == 1 ||
                visited[pos.getI()][pos.getJ()]) {
            return false;
        }
        return true;
    }

    private boolean dfs(Pair<Integer, Integer> currentPos) {
        System.out.println(currentPos.toString() + " ");
        if(currentPos.equals(destination)) {
            return true;
        }
        if(isFeasible(currentPos)) {
            int i = currentPos.getI(), j = currentPos.getJ();
            visited[i][j] = true;
            if(dfs(new Pair<>(i+1, j))) {
                escapeRoute[i+1][j] = 'S';
                return true;
            }
            if(dfs(new Pair<>(i-1, j))){
                escapeRoute[i-1][j] = 'S';
                return true;
            }
            if(dfs(new Pair<>(i, j+1))) {
                escapeRoute[i][j+1] = 'S';
                return true;
            }
            if(dfs(new Pair<>(i, j-1))) {
                escapeRoute[i][j-1] = 'S';
                return true;
            }
        }
        return false;
    }

    public boolean findPath(Pair<Integer, Integer> start) {
        System.out.println("Traversal Path:");
        if(dfs(start)) {
            escapeRoute[start.getI()][start.getJ()] = '2';
            escapeRoute[destination.getI()][destination.getJ()] = '3';
            return true;
        }
        return false;
    }
}
