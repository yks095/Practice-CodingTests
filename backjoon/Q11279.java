package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 최대 힙
 * https://www.acmicpc.net/problem/11279
 */
public class Q11279 {
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        queue = new PriorityQueue<>(Collections.reverseOrder());

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
