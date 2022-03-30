package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 결혼식
 * https://www.acmicpc.net/problem/5567
 */
public class Q5567 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] relations;
    static int n, m;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        input();

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(relations[i][j] > relations[i][k] + relations[k][j]) {
                        relations[i][j] = relations[i][k] + relations[k][j];
                    }
                }
            }
        }

        int result = 0;
        for(int i = 2; i < relations[1].length; i++)    {
            if(relations[1][i] != 0 && relations[1][i] <= 2)   {
                result++;
            }
        }

        System.out.println(result);

    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        relations = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j)  {
                    relations[i][j] = 0;
                } else  {
                    relations[i][j] = INF;
                }
            }
        }

        for(int i  = 1; i <= m; i++) {
            String line = br.readLine();
            int a = Integer.parseInt(line.split("\\s+")[0]);
            int b = Integer.parseInt(line.split("\\s+")[1]);

            relations[a][b] = relations[b][a] = 1;
        }
    }
}
