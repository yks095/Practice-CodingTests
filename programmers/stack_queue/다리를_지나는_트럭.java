package programmers.stack_queue;

import java.util.Stack;

public class 다리를_지나는_트럭 {
    public static void main(String[] args)  {
        int weight = 10;
        int bridge_length = 2;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(weight, bridge_length, truck_weights));
    }

    public static int solution(int weight, int bridge_length, int[] truck_weights)  {
        int answer = 0;

        Stack<Integer> bridge = new Stack<>();

        for(int i = truck_weights.length - 1; i >= 0; i--)  {
            bridge.push(truck_weights[i]);
        }

        while(!bridge.isEmpty())    {
            int truck = bridge.pop();
            answer++;
            if(truck + bridge.peek() <= weight) {
                bridge.pop();
                answer++;
            }
        }

        return answer;
    }
}
