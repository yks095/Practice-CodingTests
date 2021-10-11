package backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Queue;

public class Q2178 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y)  {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {0, 1, 0, -1, -1, 1, 1, -1};
    private static final int[] dy = {1, 0, -1, 1, 1, 1, -1, -1};
    private static char[][] maze;
    private static boolean[][] isVisited;
    private static Queue<Point> queue;
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int N;
    private static int M;
    private static String[] size;
    private static int count;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = br.readLine().split("\\s+");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        maze = new char[N][M];
        count = 0;

        while(count != N) {
            maze[count] = br.readLine().toCharArray();
            count++;
        }
        count = 0;

        for(int i = 0; i < N; i++)  {
            for(int j = 0; j < M; j++)  {
                if(maze[i][j] == 1 && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    count++;
                    bfs(i, j, count);
                }
            }
        }

        System.out.println(count);


    }

    private static void bfs(int i, int j, int count) {
        queue.offer(new Point(i, j));
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int point_x = point.x;
            int point_y = point.y;

            for(int k = 0; k < dx.length; k++)  {
                int x = point_x + dx[k];
                int y = point_y + dy[k];
                if((x >= 0) && (x < N) && (y >= 0) && (y < M) && (maze[x][y] == '1'))  {
                    count++;
                    queue.offer(new Point(x, y));
                }
            }
        }
    }
}
