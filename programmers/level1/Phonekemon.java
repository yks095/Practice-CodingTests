package programmers.level1;

import java.util.HashSet;

/**
 * 폰케몬
 * https://programmers.co.kr/learn/courses/30/lessons/1845?language=java
 */
public class Phonekemon {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        System.out.println(solution(nums));

    }

    private static int solution(int[] nums) {
        int availableSize = nums.length / 2;

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            hashSet.add(i);
        }

        if (availableSize > hashSet.size()) {
            return hashSet.size();
        } else  {
            return availableSize;
        }
    }
}
