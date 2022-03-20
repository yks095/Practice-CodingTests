package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 포도주 시식
 * https://www.acmicpc.net/problem/2156
 */
public class Q2156 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] wine;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        wine = new int[n + 1];
        dp = new int[n + 1];

        for(int i = 1; i <= n; i++)  {
            wine[i] = Integer.parseInt(br.readLine());
        }


        for(int i = 1; i <= n; i++)  {
            if(i == 1)  {
                dp[1] = wine[1];
            } else if(i == 2)   {
                dp[2] = wine[1] + wine[2];
            } else if(i == 3)   {
                dp[3] = Math.max(dp[2], Math.max(dp[1] + wine[3], wine[2] + wine[3]));
            } else  {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
            }
        }

        System.out.println(dp[n]);

    }
}
