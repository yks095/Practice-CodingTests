package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연속합
 * https://www.acmicpc.net/problem/1912
 */
public class Q1912 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] num;
    static int[] dp;
    static int max = -1001;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        num = new int[n + 1];
        dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while(st.hasMoreTokens())   {
            num[++idx] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            if(i == 1)  {
                dp[i] = num[i];
            } else  {
                dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
            }
        }

        for(int i = 1; i <= n; i++) {
            if(dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}

