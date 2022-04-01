package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 수열 정렬
 * https://www.acmicpc.net/problem/1015
 */
public class Q1015 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static Point[] B;
    static int[] P;

    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(B);

        for(int i = 0; i < N; i++)  {
            P[B[i].idx] = i;
        }

        for (int p : P) {
            sb.append(p).append(" ");
        }

        System.out.println(sb);

    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        B = new Point[N];
        P = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)  {
            B[i] = new Point(Integer.parseInt(st.nextToken()), i);
        }
    }

    static class Point implements Comparable<Point>  {
        int num;
        int idx;

        public Point(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point other) {
            return num - other.num;
        }
    }
}
