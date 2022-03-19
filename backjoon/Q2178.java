package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로 탐색
 * https://www.acmicpc.net/problem/2178
 */
public class Q2178  {

    static int minCount = 0;
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] isVisited;
    // 우, 상, 좌, 하
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String firstLine = br.readLine();
        N = Integer.parseInt(firstLine.split("\\s+")[0]);
        M = Integer.parseInt(firstLine.split("\\s+")[1]);

        map = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i = 0; i < N; i++)  {
            String input = br.readLine();
            for(int j = 0; j < M; j++)   {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        isVisited[0][0] = true;
        bfs(0, 0);

        System.out.println(map[N - 1][M - 1]);

    }

    private static void bfs(int i, int j) {
        Queue<Area> queue = new LinkedList<>();
        queue.add(new Area(i, j));

        while(!queue.isEmpty()) {
            Area area = queue.poll();
            int prevX = area.x;
            int prevY = area.y;

            for(int k = 0; k < 4; k++)  {
                int x = prevX + dx[k];
                int y = prevY + dy[k];

                if(x >= 0 && y >= 0 && x < N && y < M)  {
                    if(map[x][y] == 1 && !isVisited[x][y])  {
                        isVisited[x][y] = true;
                        minCount++;
                        queue.add(new Area(x, y));
                        map[x][y] = map[prevX][prevY] + 1;
                    }
                }
            }
        }

    }

    static class Area   {
        int x;
        int y;

        public Area(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

































