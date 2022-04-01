package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 수의 합
 * https://www.acmicpc.net/problem/3273
 */
public class Q3273 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, x, result = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(arr);
        twoPointer(1, n);

        System.out.println(result);
    }

    private static void twoPointer(int left, int right) {
        while(left < right)    {
            int sum = arr[left] + arr[right];

            if(sum == x) {
                result++;
            }

            if(sum <= x) {
                left++;
            } else  {
                right--;
            }
        }
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());
    }
}
