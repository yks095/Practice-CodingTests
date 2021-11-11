package programmers.level1;

/**
 * x만큼 간격이 있는 n개의 숫자
 * https://programmers.co.kr/learn/courses/30/lessons/12954
 */
public class IntervalNumber {
    public static void main(String[] args) {
        int x = -4;
        int n = 2;

        solution(x, n);
    }

    private static long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;

        for(int i = 1; i < n; i++)  {
            answer[i] = answer[i - 1] + x;
            System.out.println(answer[i]);
        }

        return answer;
    }
}
