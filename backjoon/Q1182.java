package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부분수열의 합
 * https://www.acmicpc.net/problem/1182
 */
public class Q1182 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int S;
    static int result = 0;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        init();

        recursive(1, 0);

        if(S == 0)  {
            result--;
        }
        System.out.println(result);
    }

    private static void recursive(int k, int sum) {
        if(k == N + 1) {
            if (sum == S) {
                result++;
            }
        } else    {
            recursive(k + 1, sum + nums[k]);

            recursive(k + 1, sum);
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
