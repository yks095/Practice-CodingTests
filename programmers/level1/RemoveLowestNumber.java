package programmers.level1;

/**
 * 제일 작은 수 제거
 * https://programmers.co.kr/learn/courses/30/lessons/12935?language=java
 */
public class RemoveLowestNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        solution(arr);
    }

    private static int[] solution(int[] arr) {
        if(arr.length == 1) {
            return new int[]{-1};
        }

        int[] newArr = new int[arr.length - 1];
        int lowestNumber = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] <= lowestNumber)  {
                lowestNumber = arr[i];
            }
        }

        int cnt = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != lowestNumber)  {
                newArr[cnt++] = arr[i];
            }
        }

        return newArr;
    }
}
