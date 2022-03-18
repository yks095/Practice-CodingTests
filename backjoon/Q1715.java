package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 카드 정렬하기
 * https://www.acmicpc.net/problem/1715
 */
public class Q1715 {

    static PriorityQueue<Integer> queue;
    static Stack<Integer> stack;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int result = 0;
        int N = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();
        stack = new Stack<>();

        for(int i = 0; i < N; i++)  {
            queue.add(Integer.parseInt(br.readLine()));
        }

        while(!queue.isEmpty()) {
            int minA = queue.poll();
            if(!queue.isEmpty()) {
                int minB = queue.poll();
                stack.push(minA + minB);
                queue.add(minA + minB);
            }
        }

        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}
