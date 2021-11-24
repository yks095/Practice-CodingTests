package programmers.level2;

import java.util.Stack;

/**
 * N개의 최소공배수
 * https://programmers.co.kr/learn/courses/30/lessons/12953?language=java
 */
public class CommonNumberN {
    public static void main(String[] args) {
        int[] arr = {3,4,9,16};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int j : arr) {
            stack.push(j);

            if (stack.size() == 2) {
                int a = stack.pop();
                int b = stack.pop();

                stack.push((a * b) / calculateGcd(a, b));
            }
        }

        return stack.pop();
    }

    private static int calculateGcd(int max, int min) {
        if(min == 0)  {
            return max;
        }
        return calculateGcd(min, max % min);
    }
}
