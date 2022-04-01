package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 카드
 * https://www.acmicpc.net/problem/11652
 */
public class Q11652 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] cards;

    public static void main(String[] args) throws IOException {
        input();

        Arrays.sort(cards);

        int count = 1;
        int maxCount = 1;
        long maxNum = cards[0];

        for(int i = 1; i < N; i++)  {
            if(cards[i] == cards[i - 1])    {
                count++;
            } else  {
                count = 1;
            }

            if(count > maxCount)    {
                maxCount = count;
                maxNum = cards[i];
            }
        }

        System.out.println(maxNum);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        cards = new long[N];

        for(int i = 0; i < N; i++)  {
            cards[i] = Long.parseLong(br.readLine());
        }
    }
}
