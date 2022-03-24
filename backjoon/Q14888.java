package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연산자 끼워넣기
 * https://www.acmicpc.net/problem/14888
 */
public class Q14888 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] operator;
    static int[] numbers;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();

        recursive(1, numbers[1]);
        System.out.println(max + "\n" + min);
    }

    private static void recursive(int i, int value) {
        if(i == N)  {
            max = Math.max(value, max);
            min = Math.min(value, min);
        } else  {
            for(int k = 1; k <= 4; k++)   {
                if(operator[k] != 0)    {
                    operator[k]--;
                    recursive(i + 1, calculate(value, k, numbers[i + 1]));
                    operator[k]++;
                }
            }
        }
    }

    private static int calculate(int operand1, int operator, int operand2) {
        if(operator == 1)  {
            return operand1 + operand2;
        }
        else if(operator == 2)  {
            return operand1 - operand2;
        }
        else if(operator == 3)  {
            return operand1 * operand2;
        }
        else {
            return operand1 / operand2;
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        operator = new int[5];
        numbers = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
    }
}
