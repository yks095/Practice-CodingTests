package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * ATM
 * https://www.acmicpc.net/problem/11399
 */
public class Q11399 {

    static PriorityQueue<Integer> queue;
    static Stack<Integer> stack = new Stack<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        int result = 0;
        int N = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens())   {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        while(!queue.isEmpty())    {
            if(stack.isEmpty()) {
                stack.push(queue.poll());
            } else  {
                stack.push(stack.peek() + queue.poll());
            }
        }

        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}
