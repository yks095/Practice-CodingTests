package programmers.level2;

import java.math.BigInteger;

public class TheNumberOfFibonacci {
    public static void main(String[] args) {
        int n = 5;

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        if(n == 0 || n == 1)    {
            return n;
        }

        int[] answer = new int[n + 1];

        for(int i = 0; i < answer.length; i++) {
            if(i == 0 || i == 1)    {
                answer[i] = i;
            } else  {
                answer[i] = (answer[i - 2] + answer[i - 1]) % 1234567;
            }

            System.out.println(answer[i]);
        }

        return answer[n] % 1234567;
    }
}
