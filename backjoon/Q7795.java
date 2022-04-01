package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 먹을 것인가 먹힐 것인가
 * https://www.acmicpc.net/problem/7795
 */
public class Q7795 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while(T-- != 0) {
            int result = 0;

            input();

            Arrays.sort(B, 1, M + 1);

            for(int i = 1; i <= N; i++)  {
                result += binarySearch(1, M, A[i]);
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int left, int right, int X) {
        int res = 0;
        while(left <= right)    {
            int mid = (left + right) / 2;
            if(B[mid] < X) {
                res = mid;
                left = mid + 1;
            } else  {
                right = mid - 1;
            }
        }

        return res;
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        B = new int[M + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)  {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++)  {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }
}
