package programmers.stack_queue;

import java.util.Arrays;
import java.util.Stack;

class Top   {
    int idx;
    int height;

    public Top(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }

    public int getIdx() {
        return idx;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Top{" +
                "idx=" + idx +
                ", height=" + height +
                '}';
    }
}

public class 탑 {

    public static void main(String[] args)  {
        int[] heights = {6, 9, 5, 7, 4};
        System.out.println(Arrays.toString(solution(heights)));
    }

    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
//        for (int i = heights.length - 1; i >= 0; i--)    {
//            for(int j = i - 1; j >= 0; j--) {
//                if(heights[i] < heights[j]) {
//                    answer[i] = j + 1;
//                    break;
//                }
//            }
//        }
        Stack<Top> stack = new Stack<>();

        for(int i = 0; i < heights.length; i++) {
            Top top = new Top(i + 1, heights[i]);
            int receiveIdx = 0;

            while(!stack.isEmpty()) {
                if(stack.peek().getHeight() > heights[i])   {
                    receiveIdx = stack.peek().getIdx();
                    break;
                }
                stack.pop();
            }
            stack.push(top);
            answer[i] = receiveIdx;
        }

        return answer;
    }
}