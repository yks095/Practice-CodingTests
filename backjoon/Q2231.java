package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분해합
 * https://www.acmicpc.net/problem/2231
 */
public class Q2231 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        init();

        for(int i = (N - (9 * count)); i < N; i++) {
            int num = i;
            int sum = i;
            while(num > 0)  {
                sum += num % 10;
                num /= 10;
            }

            if(sum == N)    {
                System.out.println(sum);
                break;
            }
        }

        System.out.println(0);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        int num = N;
        while(num > 0)  {
            num /= 10;
            count++;
        }
    }
}
