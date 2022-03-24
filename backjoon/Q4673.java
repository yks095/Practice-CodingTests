package backjoon;

/**
 * 셀프 넘버
 * https://www.acmicpc.net/problem/4673
 */
public class Q4673 {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static boolean[] isNotSelfNumber;

    public static void main(String[] args) {
        input();

        for(int i = 1; i <= N; i++) {
            constructorD(i);
        }

        output();

        System.out.println(sb);
    }

    private static void constructorD(int i) {
        int num = i;
        int sum = i;
        while(num > 0)  {
            sum += num % 10;
            num /= 10;
        }

        if(sum < N + 1) {
            isNotSelfNumber[sum] = true;
        }
    }

    private static void output() {
        for(int i = 1; i <= N; i++)   {
            if(!isNotSelfNumber[i]) {
                sb.append(i).append("\n");
            }
        }
    }

    private static void input() {
        N = 10000;
        isNotSelfNumber = new boolean[N + 1];
    }
}
