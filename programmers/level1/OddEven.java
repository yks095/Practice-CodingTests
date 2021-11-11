package programmers.level1;

/**
 * 짝수와 홀수
 * https://programmers.co.kr/learn/courses/30/lessons/12937?language=java
 */
public class OddEven {
    public static void main(String[] args) {
        int num = 4;
        System.out.println(solution(num));
    }

    private static String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
