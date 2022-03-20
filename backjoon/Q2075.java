package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * N번째 큰 수
 * https://www.acmicpc.net/problem/2075
 */
public class Q2075 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < N; i++)  {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())   {
                queue.add(Integer.parseInt(st.nextToken()));
            }
        }

        while(N-- > 1)  {
            queue.poll();
        }

        System.out.println(queue.peek());
    }
}
