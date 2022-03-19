package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단 오르기
 * https://www.acmicpc.net/problem/2579
 */
public class Q2579 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] stairs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        dp = new int[N + 1];

        for(int i = 1; i <= N; i++)  {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= N; i++) {
            if(i == 1)  {
                dp[1] = stairs[1];
            } else if(i == 2)   {
                dp[2] = stairs[1] + stairs[2];
            } else if(i == 3)   {
                dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
            } else  {
                dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
