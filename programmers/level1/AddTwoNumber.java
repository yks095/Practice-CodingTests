package programmers.level1;

import java.util.*;

/**
 * 두 개 뽑아서 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/68644?language=java
 */
public class AddTwoNumber {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        System.out.println(solution(numbers));  // 2,3,4,5,6,7

        numbers = new int[]{5,0,2,7};
        System.out.println(solution(numbers));  // 2,5,7,9,12

    }

    public static int[] solution(int[] numbers) {
        int[] answer;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                int num = numbers[i] + numbers[j];
                if(!list.contains(num)) {
                    list.add(num);
                }
            }
        }

        Collections.sort(list);
        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

}
