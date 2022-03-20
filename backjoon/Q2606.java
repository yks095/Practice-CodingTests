package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 바이러스
 * https://www.acmicpc.net/problem/2606
 */
public class Q2606 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static boolean[] isVisited;
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        for(int i = 1; i <= line; i++)   {
            String link = br.readLine();
            int a = Integer.parseInt(link.split("\\s+")[0]);
            int b = Integer.parseInt(link.split("\\s+")[1]);

            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int i) {
        isVisited[i] = true;

        for(int j = 1; j <= N; j++) {
            if(map[i][j] == 1 && !isVisited[j]) {
                dfs(j);
                count++;
            }
        }
    }
}
