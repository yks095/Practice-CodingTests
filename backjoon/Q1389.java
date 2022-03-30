package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 케빈 케이컨의 6단계 법칙
 * https://www.acmicpc.net/problem/1389
 */
public class Q1389 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] relations;
    static int result = Integer.MAX_VALUE;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        input();

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(relations[i][j] > relations[i][k] + relations[k][j]) {
                        relations[i][j] = relations[i][k] + relations[k][j];
                    }
                }
            }
        }

        int min = INF;
        for(int i = 1; i <= N; i++)   {
            int sum = 0;
            for(int j = 1; j <= N; j++)    {
                sum += relations[i][j];
            }

            if(min > sum)   {
                min = sum;
                result = i;
            }
        }

        System.out.println("\n" + result);
    }

    private static void input() throws IOException {
        String firstLine = br.readLine();
        N = Integer.parseInt(firstLine.split("\\s+")[0]);
        M = Integer.parseInt(firstLine.split("\\s+")[1]);
        relations = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++)  {
            for(int j = 1; j <= N; j++) {
                if(i == j)  {
                    relations[i][j] = 0;
                } else  {
                    relations[i][j] = INF;
                }
            }
        }

        for(int i = 1; i <= M; i++)  {
            String line = br.readLine();
            int a = Integer.parseInt(line.split("\\s+")[0]);
            int b = Integer.parseInt(line.split("\\s+")[1]);

            relations[a][b] = 1;
            relations[b][a] = 1;
        }
    }
}


// 1 0 1 1 0
// 0 0 1 0 0
// 1 1 0 1 0
// 1 0 1 0 1
// 0 0 0 1 0