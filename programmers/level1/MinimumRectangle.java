package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 최소 직사각형
 * https://programmers.co.kr/learn/courses/30/lessons/86491?language=java
 */
public class MinimumRectangle {
    public static void main(String[] args) {
        int[][] sizes = {
                {60, 50},
                {30, 70},
                {60, 30},
                {80, 40}
        };

        System.out.println(solution(sizes));
    }

    private static int solution(int[][] sizes) {
        List<Integer> bigger = new ArrayList<>();
        List<Integer> smaller = new ArrayList<>();

        for(int i = 0; i < sizes.length; i++)   {
            boolean isWidthBigger = sizes[i][0] >= sizes[i][1];

            if(isWidthBigger)   {
                bigger.add(sizes[i][0]);
                smaller.add(sizes[i][1]);
            } else  {
                bigger.add(sizes[i][1]);
                smaller.add(sizes[i][0]);
            }
        }

        Collections.sort(bigger);
        Collections.sort(smaller);

        return bigger.get(bigger.size() - 1) * smaller.get(smaller.size() - 1);
    }


}
