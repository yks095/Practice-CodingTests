package programmers.level1;

/**
 * 두 정수 사이의 합
 * https://programmers.co.kr/learn/courses/30/lessons/12912?language=java
 */
public class AddBetweenTwoNumbers {
    public static void main(String[] args) {
        int a = 3;
        int b = 3;

        System.out.println(solution(a, b));
    }

    private static long solution(int a, int b) {
        if(a == b)  {
            return a;
        }

        long sum = 0;
        int big = Math.max(a, b);
        int small = Math.min(a, b);

        for(int i = small; i <= big; i++) {
            sum += i;
        }

        return sum;
    }
}
