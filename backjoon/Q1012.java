package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 유기농 배추
 * https://www.acmicpc.net/problem/1012
 */
public class Q1012 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;
    static int M;
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cabbageCount;
    static int[][] map;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while(T-- != 0) {
            input();
            calculate();
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void calculate() {
        int count = 0;
        for(int i = 0; i < M; i++)  {
            for(int j = 0; j < N; j++)  {
                if(map[i][j] == 1 && !isVisited[i][j])  {
                    dfs(i, j);
                    count++;
                }
            }
        }

        sb.append(count);
    }

    private static void dfs(int i, int j) {
        isVisited[i][j] = true;

        for(int k = 0; k < 4; k++)  {
            int x = dx[k] + i;
            int y = dy[k] + j;
            if(x < 0 || y < 0 || x >= M || y >= N)  {
                continue;
            }
            if(isVisited[x][y]) {
                continue;
            }

            if(map[x][y] == 1 && !isVisited[x][y])  {
                dfs(x, y);
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cabbageCount = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        isVisited = new boolean[M][N];

        for(int i = 0; i < cabbageCount; i++)   {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map[idx][value] = 1;
        }
    }
}
