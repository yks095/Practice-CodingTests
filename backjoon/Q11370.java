package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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
    private static boolean[][] isVisited;
    private static BufferedReader br;
    private static String[] size;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        while(H != 0 && W != 0) {
            size = br.readLine().split("\\s+");
            H = Integer.parseInt(size[0]);
            W = Integer.parseInt(size[1]);
            solution();
        }

    }

    private static void solution() throws IOException {
        spiders = new char[W][H];
        isVisited = new boolean[W][H];

        for(int i = 0; i < W; i++)  {
            spiders[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < W; i++)  {
            for(int j = 0; j < H; j++)  {
                if(!isVisited[i][j] && spiders[i][j] == 'S')    {
                    isVisited[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        for(int i = 0; i < W; i++)  {
            for(int j = 0; j < H; j++)  {
                System.out.print(spiders[i][j]);
            }
            System.out.println();
        }
    }

    private static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int point_x = point.x;
            int point_y = point.y;

            for(int k = 0; k < dx.length; k++)  {
                int x = point_x + dx[k];
                int y = point_y + dy[k];
                if((x >= 0) && (x < W) && (y >= 0) && (y < H) && (spiders[x][y] == 'T') && !isVisited[x][y])  {
                    spiders[x][y] = 'S';
                    isVisited[x][y] = true;
                    queue.offer(new Point(x, y));
                }
            }
        }
    }
}
