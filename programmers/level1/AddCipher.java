package programmers.level1;

/**
 * 자릿수 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/12931?language=java
 */
public class AddCipher {
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        String s = String.valueOf(n);
        int sum = 0;

        for(Character c : s.toCharArray())  {
            sum += (c - 48);
        }

        return sum;
    }
}
