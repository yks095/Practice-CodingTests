//package backjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
///**
// * 평범한 배낭2
// * https://www.acmicpc.net/problem/12920
// */
//public class Q12920 {
//
//    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
//            String firstLine = br.readLine();
//
//            int N = Integer.parseInt((firstLine.split("\\s+")[0]));
//            int K = Integer.parseInt((firstLine.split("\\s+")[1]));
//
//            int[][] items = new int[N + 1][3];
//
//            for (int i = 1; i <= N; i++) {
//                String stuff = br.readLine();
//                items[i][0] = Integer.parseInt((stuff.split("\\s+")[0]));
//                items[i][1] = Integer.parseInt((stuff.split("\\s+")[1]));
//                items[i][2] = Integer.parseInt((stuff.split("\\s+")[2]));
//            }
//
//            System.out.println("\n\n" + dynamicProgramming(N, K, items));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private static int dynamicProgramming(int N, int K, int[][] items)   {
//        int[][] dp = new int[N + 1][K + 1];
//
//        for(int i = 1; i <= N; i++)  {
//            for(int j = 1; j <= K; j++)  {
//                if(items[i][0] > j)    {
//                    dp[i][j] = dp[i - 1][j];
//                } else  {
//                    if(items[i][2] > 1) {
//                        int div = j / items[i][0];
//                        int res = j % items[i][0];
//
//                        // 물건 갯수가 충분하고, 이전의 최적 해보다 크다면
//                        if(div <= items[i][2] && dp[i - 1][j] < div * items[i][2])    {
//
//                        }
//                        //
//                        else if() {
//
//                        } else  {
//                            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1]);
//                        }
//                    } else  {
//                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1]);
//                    }
//                }
//            }
//        }
//
//        for(int i = 1; i <= N; i++) {
//            System.out.println();
//            for(int j = 1; j <= K; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//        }
//
//        return dp[N][K];
//    }
//}
