package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이친수
 * https://www.acmicpc.net/problem/2193
 */
public class Q2193 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] dp;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];

        dp[1] = 1;

        if(N > 1)    {
            for(int i = 2; i <= N; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
        }

        System.out.println(dp[N]);
    }
}
