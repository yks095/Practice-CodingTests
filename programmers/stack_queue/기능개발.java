package programmers.stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));   // [2, 1]
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < progresses.length; i++)  {
            int count = 0;
            int day = (100 - progresses[i]) % speeds[i] == 0 ?
                    ((100 - progresses[i]) / speeds[i]) : ((100 - progresses[i]) / speeds[i] + 1);

            count++;
            while(!stack.isEmpty() && day <= stack.peek()) {
                stack.pop();
                count++;
            }
            stack.push(day);
            if(i != 0) {
                arrayList.add(count);
            }
        }

//        while(!stack.isEmpty())  {
//            int count = 0;
//            int poped = stack.pop();
//            count++;
//
//            if(poped <= stack.peek() && !stack.isEmpty())    {
//                stack.pop();
//                count++;
//            }
//            arrayList.add(count);
//        }

        int[] answer = new int[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++)   {
            answer[i] = arrayList.get(arrayList.size() - 1 - i);
        }

        return answer;
    }
}
