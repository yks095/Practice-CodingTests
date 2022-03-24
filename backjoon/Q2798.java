package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 블랙잭
 * https://www.acmicpc.net/problem/2798
 */
public class Q2798 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] cards;
    static int N;
    static int M;
    static int result = 0;
    static int minTerm = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();

        recursive(1, 0);

        System.out.println(result);
    }

    private static void recursive(int k, int sum) {
        if(k == 4)  {
            if(sum <= M && minTerm > (M - sum))   {
                minTerm = M - sum;
                result = sum;
            }
        } else  {
            for(int i = 1; i <= N; i++) {
                if(cards[i] != 0)   {
                    int selected = cards[i];
                    cards[i] = 0;

                    recursive(k + 1, sum + selected);

                    cards[i] = selected;
                }
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
    }
}
