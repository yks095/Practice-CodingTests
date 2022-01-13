package programmers.level2;

/**
 * 주식 가격
 * https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
 */
public class StockPrice {
    public static void main(String[] args) {
        int[] price = {1, 2, 3, 2, 3};

        int[] answer = solution(price);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++)   {
            for(int j = i + 1; j < prices.length; j++)   {
                if(prices[i] < prices[j]) {
                    System.out.println("i = " + prices[i] + ", j = " + prices[j]);
                    answer[i] += 1;
                }
            }
            System.out.println("answer = " + answer[i]);
        }

        return answer;
    }
}
