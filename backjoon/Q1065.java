package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 한수
 * https://www.acmicpc.net/problem/1065
 */
public class Q1065 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> list = new ArrayList<>();
    static int N;
    static int term;
    static int result = 0;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        calculate(N);
        System.out.println(result);
    }

    private static void calculate(int num) {
        if(num < 100) {
            result = num;
            return;
        } else if(num == 1000)  {
            num = 999;
        }

        result += 99;

        for(int i = 100; i <= num; i++)    {
            int first = i / 100;
            int second = (i / 10) % 10;
            int third = i % 10;

            if(checkNumbers(first, second, third))  {
                result++;
            }
        }
    }

    private static boolean checkNumbers(int first, int second, int third) {
        return (first - second) == (second - third);
    }
}
