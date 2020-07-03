package programmers.stack_queue;

import java.util.Arrays;

public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};         // 4, 3, 1, 1, 0
        int[] answer = solution(prices);

        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++)  {
            for(int j = i + 1; j < prices.length; j++)  {
                if(prices[i] <= prices[j])  {
                    answer[i]++;
                }
            }
        }

        return answer;

    }
}
