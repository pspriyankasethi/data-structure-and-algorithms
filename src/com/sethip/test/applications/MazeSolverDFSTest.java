package com.sethip.test.applications;

import com.sethip.main.applications.MazeSolverDFS;
import com.sethip.main.models.Pair;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
class MazeSolverDFSTest {

    int rows = 5, cols = 5;
    int[][] maze;
    char[][] escapeRouteExpected;

    @Test
    void findPathFound() {

        maze = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 2, 0, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 3}
        };
        escapeRouteExpected = new char[][]{
                {'-','-','-','-','-'},
                {'-','2','S','-','-'},
                {'-','-','S','-','-'},
                {'-','-','S','S','S'},
                {'-','-','-','-','3'}
        };

        Pair<Integer, Integer> start = new Pair<>(1,1),
                destination = new Pair<>(4,4);
        MazeSolverDFS mazeSolverDFS = new MazeSolverDFS(maze, destination);
        assert mazeSolverDFS.findPath(start);
        char[][] escapeRouteActual = mazeSolverDFS.getEscapeRoute();
        for(int i = 0; i < rows; i++) {
            assert Arrays.equals(escapeRouteActual[i], escapeRouteExpected[i]);
        }
    }

    @Test
    void findPathNotFound() {
        maze = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 2, 0, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 0, 0},
                {1, 1, 1, 1, 3}
        };
        escapeRouteExpected = new char[rows][cols];
        for(int i = 0; i < rows; i++) {
            Arrays.fill(escapeRouteExpected[i], '-');
        }
        Pair<Integer, Integer> start = new Pair<>(1,1),
                destination = new Pair<>(4,4);
        MazeSolverDFS mazeSolverDFS = new MazeSolverDFS(maze, destination);
        assert !mazeSolverDFS.findPath(start);
        char[][] escapeRouteActual = mazeSolverDFS.getEscapeRoute();
        for(int i = 0; i < rows; i++) {
            assert Arrays.equals(escapeRouteActual[i], escapeRouteExpected[i]);
        }
    }
}