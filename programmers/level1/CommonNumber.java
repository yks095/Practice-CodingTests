package programmers.level1;

/**
 * 최대공약수와 최소공배수
 * https://programmers.co.kr/learn/courses/30/lessons/12940?language=java
 */
public class CommonNumber {
    public static void main(String[] args) {
        int n = 16;
        int m = 36;

        int[] solution = solution(n, m);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int n, int m) {
        int gcd = calculateGcd(n, m);

        return new int[]{gcd, (n * m) / gcd};
    }

    private static int calculateGcd(int max, int min) {
        if(min == 0)  {
            return max;
        }
        return calculateGcd(min, max % min);
    }
}
