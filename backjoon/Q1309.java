package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 동물원
 * https://www.acmicpc.net/problem/1309
 */
public class Q1309 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[100001];
    static int N;

    public static void main(String[] args) throws IOException {
        input();

        dp[1] = 3;
        dp[2] = 7;

        if(N > 2)   {
            for(int i = 3; i <= N; i++) {
                dp[i] = (2 * dp[i - 1] + dp[i - 2]) % 9901;
            }
        }

        System.out.println(dp[N]);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
}
