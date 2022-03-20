package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 수 2
 * https://www.acmicpc.net/problem/2748
 */
public class Q2748 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[] fib = new long[n + 1];

        for(int i = 0; i <= n; i++) {
            if(i == 0)  {
                fib[i] = 0L;
            } else if(i == 1)   {
                fib[i] = 1L;
            } else  {
                fib[i] = fib[i - 2] + fib[i - 1];
            }
        }

        System.out.println(fib[n]);

    }
}
