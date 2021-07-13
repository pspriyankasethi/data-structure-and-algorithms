package com.sethip.main.applications;

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
public class CountIslandsDFS {
    int rows, cols;
    boolean[][] map;
    boolean[][] visited;

    public CountIslandsDFS(boolean[][] map) {
        this.map = map;
        this.rows = map.length;
        this.cols = rows > 0 ? map[0].length: 0;
        visited = new boolean[rows][cols];
    }

    private boolean isFeasible(int i, int j) {
        return i >= 0 && i < rows &&
                j >= 0 && j < cols &&
                !visited[i][j];
    }

    private void dfs(int i, int j) {
        if(isFeasible(i, j)) {
            visited[i][j] = true;
            if (map[i][j]) {
                int[] rowIds = {-1, -1, -1, 0, 1, 1, 1, 0};
                int[] colIds = {-1, 0, 1, 1, 1, 0, -1, -1};
                for (int iRow = 0; iRow < 8; iRow++) {
                    for (int iCol = 0; iCol < 8; iCol++) {
                        dfs(i+rowIds[iRow], j+colIds[iCol]);
                    }
                }
            }
        }
    }

    public int compute() {
        int count = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(!visited[i][j]) {
                    if(!map[i][j]) {
                        visited[i][j] = true;
                    } else {
                        dfs(i, j);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
