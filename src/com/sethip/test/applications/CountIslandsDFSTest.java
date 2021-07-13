package com.sethip.test.applications;

import com.sethip.main.applications.CountIslandsDFS;
import org.junit.jupiter.api.Test;

/*
Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island.
For example, the below matrix contains 5 islands
Example:
Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1}}
Output : 5
This is a variation of the standard problem:
“Counting the number of connected components in an undirected graph”.
*/

class CountIslandsDFSTest {

    boolean[][] map;
    CountIslandsDFS countIslandsDFS;

    @Test
    void compute() {
        map = new boolean[][]{{true, true, false, false, false},
                {false, true, false, false, true},
                {true, false, false, true, true},
                {false, false, false, false, false},
                {true, false, true, false, true}};
        countIslandsDFS = new CountIslandsDFS(map);
        assert countIslandsDFS.compute() == 5;
    }
}