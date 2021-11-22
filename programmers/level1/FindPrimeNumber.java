package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * 소수 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/12921?language=java
 */
public class FindPrimeNumber {
    public static void main(String[] args) {
        int n = 3;
        System.out.println("answer : " + solution(n));
    }

    private static int solution(int n) {
        int count = 0;
        int[] arr = new int[n + 1];

        for(int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                continue;
            }
            for(int j = i + i; j < arr.length; j += i) {
                arr[j] = 0;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                count++;
            }
        }

        return count;

    }
}
