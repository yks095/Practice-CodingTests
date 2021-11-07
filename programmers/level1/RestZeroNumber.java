package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 나누어 떨어지는 숫자 배열
 * https://programmers.co.kr/learn/courses/30/lessons/12910?language=java
 */
public class RestZeroNumber {
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        int[] solution = solution(arr, divisor);
        for (int i : solution) {
            System.out.print(" " + i);
        }
    }

    private static int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for(int i : arr)    {
            if(i % divisor == 0)    {
                list.add(i);
            }
        }

        Collections.sort(list);

        return list.size() == 0
                ? new int[]{-1}
                : list.stream().mapToInt(Integer::intValue).toArray();
    }
}
