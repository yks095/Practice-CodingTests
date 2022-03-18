package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 최소 힙
 * https://www.acmicpc.net/problem/1927
 */
public class Q1927 {

    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        queue = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                if(queue.isEmpty())  {
                    sb.append("0");
                } else  {
                    sb.append(queue.poll());
                }

                sb.append("\n");
            } else {
                queue.add(number);
            }
        }

        System.out.println(sb);
    }
}
