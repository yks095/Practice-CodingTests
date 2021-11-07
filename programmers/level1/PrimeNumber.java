package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * 소수
 * https://programmers.co.kr/learn/courses/30/lessons/12977?language=java
 */
public class PrimeNumber {
    // TODO 풀어야함
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length; i++)    {
            for(int j = i + 1; j < nums.length; j++)    {
                for(int k = j + 1; k < nums.length; k++)    {
                    answer += isPrime(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        return answer;
    }

    private static int isPrime(int num) {
        for(int i=2; i*i<=num; i++){
            if(num % i == 0)    {
                return 0;
            }
        }
        return 1;
    }
}
