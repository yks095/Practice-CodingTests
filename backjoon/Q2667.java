package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 단지번호붙이기
 * https://www.acmicpc.net/problem/2667
 */
public class Q2667 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> count = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] apart;
    static boolean[][] isVisited;
    static int N;



    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        apart = new int[N][N];
        isVisited = new boolean[N][N];

        for(int i = 0; i < N; i++)  {
            String line = br.readLine();
            for(int j = 0; j < N; j++)  {
                apart[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        for(int i = 0; i < N; i++)  {
            for(int j = 0; j < N; j++)  {
                int cnt = 1;
                if(apart[i][j] == 1 && !isVisited[i][j])    {
                    isVisited[i][j] = true;
                    cnt = bfs(i, j, cnt);
                    count.add(cnt);
                }
            }
        }

        sb.append(count.size());
        Collections.sort(count);

        for (Integer integer : count) {
            sb.append("\n").append(integer);
        }

        System.out.println(sb);
    }

    private static int bfs(int i, int j, int cnt) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));

        while (!queue.isEmpty())    {
            Point point = queue.poll();
            int prevX = point.x;
            int prevY = point.y;

            for(int k = 0; k < 4; k++)  {
                int x = prevX + dx[k];
                int y = prevY + dy[k];

                if(x < 0 || y < 0 || x >= N || y >= N)  {
                    continue;
                }

                if(apart[x][y] == 1 && !isVisited[x][y])  {
                    isVisited[x][y] = true;
                    queue.add(new Point(x, y));
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static class Point  {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
