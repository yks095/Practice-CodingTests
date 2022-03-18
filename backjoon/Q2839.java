package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 설탕 배달
 * https://www.acmicpc.net/problem/2839
 */
public class Q2839 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        while(true) {
            if(N % 5 == 0)  {
                count += (N / 5);
                break;
            } else if(N < 0)    {
                count = -1;
            }

            N -= 3;
            count++;

        }

        System.out.println(count);

    }
}
