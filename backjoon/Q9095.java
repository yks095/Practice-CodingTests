package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1,2,3 더하기
 * https://www.acmicpc.net/problem/9095
 */
public class Q9095 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] sumCount = new int[11];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        sumCount[1] = 1;
        sumCount[2] = 2;
        sumCount[3] = 4;
        for(int i = 4; i < sumCount.length; i++)    {
            sumCount[i] = sumCount[i - 3] + sumCount[i - 2] + sumCount[i - 1];
        }

        for(int i = 0; i < T; i++)  {
            int n = Integer.parseInt(br.readLine());
            sb.append(sumCount[n]).append("\n");
        }

        System.out.println(sb);

    }
}
