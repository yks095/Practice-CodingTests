package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M(4)
 * https://www.acmicpc.net/problem/15652
 */
public class Q15652 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();

        recursive(1);
        System.out.println(sb);
    }

    private static void recursive(int i) {
        if(i == M + 1)  {
            for(int k = 1; k <= M; k++) {
                sb.append(arr[k]).append(" ");
            }

            sb.append("\n");
        } else  {
            for(int k = 1; k <= N; k++) {
                if(arr[i - 1] <= k)  {
                    arr[i] = k;
                    recursive(i + 1);
                    arr[i] = 0;
                }
            }
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
    }
}


