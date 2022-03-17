package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 연결 요소의 개수
 * https://www.acmicpc.net/problem/11724
 */
public class Q11724 {

    static int[][] map;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        String firstLine = br.readLine();

        int N = Integer.parseInt(firstLine.split("\\s+")[0]);
        int M = Integer.parseInt(firstLine.split("\\s+")[1]);

        map = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        for(int i = 0; i < M; i++)  {
            String line = br.readLine();
            int x = Integer.parseInt(line.split("\\s+")[0]);
            int y = Integer.parseInt(line.split("\\s+")[1]);

            map[x][y] = 1;
            map[y][x] = 1;
        }

        for(int i = 1; i <= N; i++) {
            if(!isVisited[i])   {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int i) {
        isVisited[i] = true;

        for(int j = 1; j < isVisited.length; j++)  {
            if(map[i][j] == 1 && !isVisited[j]) {
                dfs(j);
            }
        }
    }
}
