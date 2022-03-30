package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토
 * https://www.acmicpc.net/problem/7569
 */
public class Q7569 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Point> queue = new LinkedList<>();
    static StringTokenizer st;
    static int M, N, H;
    static int[][][] tomatoBox;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(bfs());
    }

    private static int bfs() {
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int prevHeight = point.height;
            int prevCol = point.col;
            int prevRow = point.row;

            for(int i = 0; i < 6; i++)  {
                int height = prevHeight + dz[i];
                int row = prevRow + dx[i];
                int col = prevCol + dy[i];

                if(row < 1 || col < 1 || height < 1 || row > N || col > M || height > H)    {
                    continue;
                }

                if(tomatoBox[height][row][col] == -1)   {
                    continue;
                }

                if(tomatoBox[height][row][col] == 0)    {
                    tomatoBox[height][row][col] = tomatoBox[prevHeight][prevRow][prevCol] + 1;
                    queue.add(new Point(height, row, col));
                }
            }
        }

        for(int i = 1; i <= H; i++) {
            System.out.println();
            for(int j = 1; j <= N; j++) {
                System.out.println();
                for(int k = 1; k <= M; k++) {
                    System.out.print(tomatoBox[i][j][k] + " ");
                }
            }
        }


        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= H; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= M; k++) {
                    if(tomatoBox[i][j][k] == 0) {
                        return -1;
                    }

                    max = Math.max(max, tomatoBox[i][j][k]);
                }
            }
        }

        return max == 1 ? 0 : (max - 1);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomatoBox = new int[H + 1][N + 1][M + 1];

        for(int i = 1; i <= H; i++) {
            for(int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= M; k++) {
                    tomatoBox[i][j][k] = Integer.parseInt(st.nextToken());

                    if(tomatoBox[i][j][k] == 1) {
                        queue.add(new Point(i, j, k));
                    }
                }
            }
        }
    }

    static class Point  {
        int height;
        int row;
        int col;

        public Point(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }
    }
}
