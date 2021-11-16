package programmers.level1;

/**
 * 나머지가 1이 되는 수 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/87389?language=java
 */
public class DivideRestOne {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        for(int i = 1; i <= Math.sqrt(n); i++)  {
            if(n % i == 1)  {
                return i;
            }
        }

        return n - 1;
    }
}
