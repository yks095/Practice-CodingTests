package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최솟값 찾기
 * https://www.acmicpc.net/problem/11003
 */
public class Q11003 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A[i] = Integer.parseInt(st.nextToken());

            if(i <= L)  {
                queue.add(A[i]);
            }
        }

        for(int i = 1; i <= N; i++) {
            if(i <= L)  {
                sb.append(queue.peek());
            } else  {

            }

            sb.append(" ");
        }



    }
}
