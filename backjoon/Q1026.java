package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 보물
 * https://www.acmicpc.net/problem/1026
 */
public class Q1026 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Integer[] A;
    static Integer[] B;

    public static void main(String[] args) throws IOException {
        int result = 0;
        int N = Integer.parseInt(br.readLine());
        A = new Integer[N];
        B = new Integer[N];

        for(int i = 0; i < 2; i++)  {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)  {
                int number = Integer.parseInt(st.nextToken());
                if(i == 0)  {
                    A[j] = number;
                } else  {
                    B[j] = number;
                }
            }
        }

        Arrays.sort(A);
        Arrays.sort(B, Comparator.reverseOrder());

        for(int i = 0; i < N; i++)  {
            result += (A[i] * B[i]);
        }

        System.out.println(result);
    }
}
