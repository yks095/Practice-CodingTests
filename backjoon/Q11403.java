package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 경로 찾기
 * https://www.acmicpc.net/problem/11403
 */
public class Q11403 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        input();

        for(int i = 0; i < N; i++)  {
            for(int j = 0; j < N; j++)  {
                for(int k = 0; k < N; k++)  {
                    if(graph[j][i] == 1 && graph[i][k] == 1)    {
                        graph[j][k] = 1;
                    }
                }
            }
        }

        output();
    }


    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int i = 0; i < N; i++)  {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)  {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void output() {
        for(int i = 0; i < N; i++)  {
            System.out.println();
            for(int j = 0; j < N; j++)  {
                System.out.print(graph[i][j] + " ");
            }
        }
    }
}
