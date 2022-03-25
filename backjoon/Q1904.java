package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 01타일
 * https://www.acmicpc.net/problem/1904
 */
public class Q1904 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        input();

        if (N > 6) {
            for (int i = 7; i <= N; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % 15746;
            }
        }

        System.out.println(dp[N]);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        dp[5] = 8;
        dp[6] = 13;
    }
}
