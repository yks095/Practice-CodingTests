package programmers.greedy;

import java.util.Arrays;

public class 체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(n, lost, reserve));         // 5

        n = 5;
        lost = new int[]{2, 4};
        reserve = new int[]{3};
        System.out.println(solution(n, lost, reserve));         // 4

        n = 3;
        lost = new int[]{3};
        reserve = new int[]{1};
        System.out.println(solution(n, lost, reserve));         // 2

        n = 5;
        lost = new int[]{3, 5};
        reserve = new int[]{2, 4};
        System.out.println(solution(n, lost, reserve));         // 5


    }

    private static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        for(int i = 0; i < reserve.length; i++) {
            arr[reserve[i] - 1]++;
        }

        for(int i = 0; i < lost.length; i++)    {
            arr[lost[i] - 1]--;
        }

        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                if(i == 0)  {
                    if(arr[i + 1] == 2) {
                        arr[i]++;
                        arr[i + 1]--;
                    }
                }
                else if(i == arr.length - 1) {
                    if(arr[i - 1] == 2) {
                        arr[i]++;
                        arr[i - 1]--;
                    }
                }

                else {
                    if (arr[i - 1] == 2) {
                        arr[i]++;
                        arr[i - 1]--;
                    } else if (arr[i + 1] == 2) {
                        System.out.println("i : " + i);
                        arr[i]++;
                        arr[i + 1]--;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0)  {
                answer++;
            }
        }

        return answer;
    }
}
