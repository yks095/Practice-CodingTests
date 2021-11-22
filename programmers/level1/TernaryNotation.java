package programmers.level1;

/**
 * 3진법 뒤집기
 * https://programmers.co.kr/learn/courses/30/lessons/68935?language=java
 */
public class TernaryNotation {
    public static void main(String[] args) {
        int n = 45;

//        System.out.println(Math.pow(3, 3));
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0)    {
            int rest = n % 3;
            sb.append(rest);
            n /= 3;
        }

        return Integer.parseInt(sb.toString(), 3);
    }
}
