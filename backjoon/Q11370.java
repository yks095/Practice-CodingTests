package backjoon;

import java.io.*;
import java.util.*;

public class Q11370 {

    private static class Point  {
        public int x;
        public int y;

        public Point(int x, int y)  {
            this.x = x;
            this.y = y;
        }
    }

    private static int W = -1;
    private static int H = -1;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static char[][] spiders;
    private static Queue<Point> queue;
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(H != 0 && W != 0) {
            String[] size = br.readLine().split("\\s+");
            H = Integer.parseInt(size[0]);
            W = Integer.parseInt(size[1]);
            queue = new LinkedList<>();
            solution();
        }

        bw.flush();
        bw.close();

    }

    private static void solution() throws IOException {
        spiders = new char[W][H];

        for(int i = 0; i < W; i++)  {
            String line = br.readLine();
            for(int j = 0; j < H; j++)  {
                spiders[i][j] = line.charAt(j);
                if(spiders[i][j] == 'S')    {
                    queue.offer(new Point(i, j));
                }
            }
        }

        bfs();

        for(int i = 0; i < W; i++)  {
            for(int j = 0; j < H; j++)  {
                bw.write(String.valueOf(spiders[i][j]));
            }
            bw.newLine();
        }
    }

    private static void bfs() {
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int point_x = point.x;
            int point_y = point.y;

            for(int k = 0; k < dx.length; k++)  {
                int x = point_x + dx[k];
                int y = point_y + dy[k];
                if((x >= 0) && (x < W) && (y >= 0) && (y < H) && (spiders[x][y] == 'T'))  {
                    spiders[x][y] = 'S';
                    queue.offer(new Point(x, y));
                }
            }
        }
    }
}

// reference : Spawn of Ungoliant (https://www.acmicpc.net/problem/11370)

