package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스티커
 * https://www.acmicpc.net/problem/9465
 */
public class Q9456 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, n;
    static int[][] stickers;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while(T-- != 0) {
            input();

            dp[1][0] = stickers[1][0];
            dp[1][1] = stickers[1][1];

            for(int i = 2; i <= n; i++) {
                dp[i][0] = Math.max(
                        dp[i - 1][1] + stickers[i][0],
                        Math.max(dp[i - 2][0], dp[i - 2][1]) + stickers[i][0]
                );

                dp[i][1] = Math.max(
                        dp[i - 1][0] + stickers[i][1],
                        Math.max(dp[i - 2][0], dp[i - 2][1]) + stickers[i][1]
                );
            }

            sb.append(Math.max(dp[n][0], dp[n][1])).append("\n");
        }

        System.out.println(sb);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        stickers = new int[n + 1][2];
        dp = new int[n + 1][2];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            stickers[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            stickers[i][1] = Integer.parseInt(st.nextToken());
        }

    }
}
