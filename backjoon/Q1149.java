package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * RGB거리
 * https://www.acmicpc.net/problem/1149
 */
public class Q1149 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] costs;
    static int[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        input();

        dp[1][0] = costs[1][0];
        dp[1][1] = costs[1][1];
        dp[1][2] = costs[1][2];

        for(int i = 2; i <= N; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(
                Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]))
        );
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        costs = new int[N + 1][3];
        dp = new int[N + 1][3];

        for(int i = 1; i <= N; i++)  {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < costs[i].length; j++)    {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
