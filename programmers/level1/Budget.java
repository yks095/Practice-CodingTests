package programmers.level1;

import java.util.Arrays;

/**
 * 예산
 * https://programmers.co.kr/learn/courses/30/lessons/12982?language=java
 */
public class Budget {
    public static void main(String[] args) {
        int[] d = {2,2,3,3};
        int budget = 8;
        System.out.println(solution(d, budget));
    }

    private static int solution(int[] d, int budget) {
        Arrays.sort(d);

        for(int i = 0;  i < d.length; i++)  {
            budget -= d[i];

            System.out.println(budget + ", " + d[i]);

            if(budget < 0) {
                return i;
            } else if(budget == 0)  {
                return i + 1;
            }
        }

        return d.length;
    }
}
