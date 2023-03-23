package com.amazon.tasks;

public class Tasks {
    public static int getNumberOfStores(int [][] map) {
        int res = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[x][y] == 1) {
                    bfs(map, x, y, 0);
                }
            }
        }

        return res;
    }

    private static void bfs(int[][] map, int x, int y, int prevCount) {
//        if()
    }
}
