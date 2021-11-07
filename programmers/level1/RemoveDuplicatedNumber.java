package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * 같은 숫자는 싫어
 * https://programmers.co.kr/learn/courses/30/lessons/12906?language=java
 */
public class RemoveDuplicatedNumber {
    public static void main(String[] args) {
        int[] arr = {4,4,4,3,3};
        int[] solution = solution(arr);

    }

    private static int[] solution(int[] arr) {
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        list.add(arr[idx]);

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != list.get(idx)) {
                list.add(arr[i]);
                idx++;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
