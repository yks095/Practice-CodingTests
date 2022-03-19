package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 함수
 * https://www.acmicpc.net/problem/1003
 */
public class Q1003 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++)  {
            int number = Integer.parseInt(br.readLine());
            dp = new int[number + 2][2];
            calculateCount(number);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void calculateCount(int number) {
        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;

        if(number != 0 && number != 1)  {
            for(int i = 2; i <= number; i++)    {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
            }
        }

        sb.append(dp[number][0]).append(" ").append(dp[number][1]);
    }
}
