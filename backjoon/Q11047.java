package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 동전 0
 * https://www.acmicpc.net/problem/11047
 */
public class Q11047 {

    static PriorityQueue<Integer> queue;

    static int count = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        queue = new PriorityQueue<>(Comparator.reverseOrder());

        String firstLine = br.readLine();
        int N = Integer.parseInt(firstLine.split("\\s+")[0]);
        int K = Integer.parseInt(firstLine.split("\\s+")[1]);

        for(int i = 0; i < N; i++)  {
            queue.add(Integer.parseInt(br.readLine()));
        }

        while(!queue.isEmpty() && K != 0) {
            if(queue.peek() > K)    {
                queue.poll();
            } else {
                K -= queue.peek();
                count++;
            }
        }

        System.out.println(count);
    }
}
