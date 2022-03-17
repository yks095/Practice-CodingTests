package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이항 계수 3
 * https://www.acmicpc.net/problem/11401
 */
public class Q11401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();

        int N = Integer.parseInt(firstLine.split("\\s+")[0]);
        int K = Integer.parseInt(firstLine.split("\\s+")[1]);

        int number = factorial(N, 1) / factorial(N-K, 1) / factorial(K, 1);

        System.out.println(number % 1000000007);
    }

    private static int factorial(int i, int j) {
        return i == 1 ? j : factorial(i - 1, i * j);
    }
}
