package programmers.level1;

/**
 * 평균 구하기
 * https://programmers.co.kr/learn/courses/30/lessons/12944?language=java
 */
public class Average {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(solution(arr));
    }

    private static double solution(int[] arr) {
        double sum = 0.0;

        for(int i : arr)    {
            sum += i;
        }

        return sum / arr.length;
    }
}
