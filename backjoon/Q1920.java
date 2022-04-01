package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 수 찾기
 * https://www.acmicpc.net/problem/1920
 */
public class Q1920 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(A, 1, N + 1);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)  {
            int m = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(m, 1, N)).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int m, int left, int right) {
        boolean isExist = false;
        while(left <= right)    {
            int mid = (left + right) / 2;
            if(A[mid] < m)  {
                left = mid + 1;
            } else  {
                right = mid - 1;
            }

            if(A[mid] == m) {
                isExist = true;
            }
        }

        return isExist ? 1 : 0;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
    }
}
