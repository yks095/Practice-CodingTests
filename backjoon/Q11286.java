package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 절댓값 힙
 * https://www.acmicpc.net/problem/11286
 */
public class Q11286 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) {
                return o1 > o2 ? 1 : -1;
            } else {
                return abs1 - abs2;
            }
        });

        for(int i = 0; i < N; i++)  {
            int number = Integer.parseInt(br.readLine());

            if(number == 0) {
                if(queue.isEmpty()) {
                    sb.append(0);
                } else  {
                    sb.append(queue.poll());
                }

                sb.append("\n");
            } else  {
                queue.add(number);
            }
        }

        System.out.println(sb);
    }
}
