package programmers.weekly;

/**
 * 1주차 부족한 금액 계산하기
 * https://programmers.co.kr/learn/courses/30/lessons/82612?language=java
 */
public class FirstWeek {

    public static void main(String[] args) {
        long answer = solution(3, 20, 4);
        System.out.println(answer);
    }


    public static long solution(int price, int money, int count) {
        long answer;
        long totalPrice = 0;

        while(count != 0) {
            totalPrice += (count-- * price);
        }

        answer = totalPrice - money;

        return answer < 0 ? 0 : answer;
    }
}
