package programmers.level1;

/**
 * 정수 제곱근 판별
 * https://programmers.co.kr/learn/courses/30/lessons/12934?language=java
 */
public class SquareRoot {
    public static void main(String[] args) {
        long n = 121;
        System.out.println(solution(n));
    }

    private static long solution(long n) {
        double answer = Math.sqrt(n);

        if(answer - (long) answer != 0.0)   {
            return -1;
        } else  {
            return ((long)answer + 1) * ((long)answer + 1);
        }
    }
}
