package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repeat {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();
        int N = Integer.parseInt(firstLine.split("\\s+")[0]);
        int K = Integer.parseInt(firstLine.split("\\s+")[1]);

        int[][] items = new int[N + 1][K + 1];
        int[][] dp = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++) {
            String stuff = br.readLine();
            items[i][0] = Integer.parseInt(stuff.split("\\s+")[0]);
            items[i][1] = Integer.parseInt(stuff.split("\\s+")[1]);
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                if(items[i][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else  {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}
