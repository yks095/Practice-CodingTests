//package programmers.kakao;
//
///**
// * 양궁 대회
// * https://programmers.co.kr/learn/courses/30/lessons/92342
// */
//public class ArcheryCompetition {
//    public static void main(String[] args) {
//        int n = 5;
//        int[] info = {2,1,1,1,0,0,0,0,0,0,0};   // 0,2,2,0,1,0,0,0,0,0,0
//
//        int[] answer = solution(n, info);
//        for (int i : answer) {
//            System.out.print(i + " ");
//        }
//    }
//
//    static int maxDiff = Integer.MIN_VALUE;
//
//    private static int[] solution(int n, int[] info) {
//        int[] apeach = new int[n];
//        int[] ryan = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            apeach[i] = info[i];
//        }
//
//        dfs(apeach, ryan, 0, 0, 0, 0);
//
//        if(maxDiff <= 0)    {
//            return new int[]{-1};
//        }
//
//        return new int[]{};
//    }
//}