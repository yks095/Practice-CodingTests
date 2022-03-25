package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쉬운 계단 수
 * https://www.acmicpc.net/problem/10844
 */
public class Q10844 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        dp = new int[101];
        dp[1] = 9;
        dp[2] = 17;
        dp[3] = 32;

        if(N == 1 || N == 2)  {
            System.out.println(dp[N]);
        } else {
            for(int i = 4; i <= N; i++)  {
                dp[i] = (dp[i - 1] * 2) + 1;
            }

            System.out.println(dp[N]);
        }
    }
}
