package programmers.sort;

import java.util.Arrays;

public class 가장큰수 {
    public static void main(String[] args)  {
        System.out.println(solution(new int[]{6, 10, 2}));              // 6210
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));       // 9534330
    }

    private static String solution(int[] numbers) {
        String result = "";
        String[] results = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            results[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(results);

        return Arrays.toString(results);
    }
}
