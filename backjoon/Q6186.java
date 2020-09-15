package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6186 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[][] map = new String[R][C];
        boolean[][] isVisited = new boolean[R][C];
        int clump = 0;

        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++)  {
                map[i][j] = String.valueOf(line.charAt(j));
            }
        }

        for(int i = 0; i < R; i++) {

            for(int j = 0; j < C; j++)  {
                if("#".equals(map[i][j]) && !isVisited[i][j])   {
                    isVisited[i][j] = true;
                    checkClumps(map, i, j, isVisited);
                    clump++;
                }
            }
        }

        System.out.println(clump);

    }

    private static void checkClumps(String[][] map, int i, int j, boolean[][] isVisited) {
        visitRow(map, i, j, isVisited);
        visitColumn(map, i, j, isVisited);
    }

    private static void visitRow(String[][] map, int i, int j, boolean[][] isVisited) {
        int r = j;
        while(isVisited[i][r] && ++r < map[i].length)  {
            if("#".equals(map[i][r])) {
                isVisited[i][r] = true;
            }
        }
    }

    private static void visitColumn(String[][] map, int i, int j, boolean[][] isVisited) {
        int c = i;
        while(isVisited[c][j] && ++c < map.length)  {
            if("#".equals(map[c][j])) {
                isVisited[c][j] = true;
            }
        }
    }
}

// reference : Best Grass (https://www.acmicpc.net/problem/6186)
