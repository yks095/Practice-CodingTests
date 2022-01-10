package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 기능 개발
 * https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
 */
public class DevelopFunction {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};      // 3

        int[] answer = solution(progresses, speeds);        // {2, 1}
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for(int i = progresses.length - 1; i >= 0; i--)  {
            int day = (100 - progresses[i]) % speeds[i] == 0 ?
                    ((100 - progresses[i]) / speeds[i]) : ((100 - progresses[i]) / speeds[i] + 1);
            stack.push(day);
            System.out.println(day);
        }
        System.out.println();

        while(!stack.isEmpty()) {
            int cnt = 1;
            int number = stack.pop();
            System.out.println();
            System.out.println("number = " + number);

            while(!stack.isEmpty()) {
                if(stack.peek() <= number)  {
                    System.out.println(stack.peek());
                    stack.pop();
                    cnt++;
                } else {
                    break;
                }
            }

            list.add(cnt);
        }

        System.out.println();

        return list.stream().mapToInt(i -> i).toArray();

    }
}
