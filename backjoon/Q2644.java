package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 촌수계산
 * https://www.acmicpc.net/problem/2644
 */
public class Q2644 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int start, end;
    static int m;
    static int[][] relation;
    static boolean[] isVisited;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        input();

        dfs(start, 0);

        System.out.println(result);

    }

    private static void dfs(int i, int cnt) {
        if(i == end)    {
            result = cnt;
            return;
        }
        isVisited[i] = true;

        for(int j = 1; j <= n; j++)  {
            if(relation[i][j] == 1 && !isVisited[j])    {
                dfs(j, cnt + 1);
            }
        }

    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        relation = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        for(int i = 1; i <= m; i++)  {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a][b] = 1;
            relation[b][a] = 1;
        }
    }
}
