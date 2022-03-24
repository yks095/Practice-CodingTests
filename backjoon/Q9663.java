package backjoon;

import java.util.Scanner;

/**
 * N-Queen
 * https://www.acmicpc.net/problem/9663
 */
public class Q9663 {

    static int N, result;
    static int[] chess;

    public static void main(String[] args) {
        init();

        recursive(1);
        System.out.println(result);
    }

    private static void recursive(int row) {
        if(row == N + 1)  {
            result++;
        } else  {
            for(int c = 1; c <= N; c++) {
                boolean isPossible = true;
                for(int i = 1; i <= row - 1; i++) {
                    if(isAttackable(row, c, i, chess[i])) {
                        isPossible = false;
                        break;
                    }
                }

                if(isPossible)    {
                    chess[row] = c;
                    recursive(row + 1);
                    chess[row] = 0;
                }
            }
        }
    }

    private static boolean isAttackable(int r1, int c1, int r2, int c2)   {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        chess = new int[N + 1];
    }
}
