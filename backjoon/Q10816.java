//package backjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
///**
// * 숫자 카드 2
// * https://www.acmicpc.net/problem/10816
// */
//public class Q10816 {
//
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer st;
//    static int N, M;
//    static int[] A, B;
//
//    public static void main(String[] args) throws IOException {
//        input();
//
//        Arrays.sort(A);
//
//
//        for(int i = 1; i <= M; i++) {
//            sb.append(binarySearch(1, M, B[i])).append(" ");
//        }
//
//        System.out.println(sb);
//    }
//
//    private static int binarySearch(int left, int right, int num) {
//        int upperIdx = getUpperIdx(left, right, num);
//        int lowerIdx = getLowerIdx(left, right, num);
//
//        System.out.println("num : " + num + ", up : " + upperIdx + ", low : " + lowerIdx);
//
//        return upperIdx - lowerIdx;
//    }
//
//    private static int getUpperIdx(int left, int right, int num) {
//        while(left <= right)    {
//            int mid = (left + right) / 2;
//
//            if(A[mid] > num)    {
//
//            }
//        }
//
//        return left;
//    }
//
//    private static int getLowerIdx(int left, int right, int num) {
//        while(left <= right)    {
//            int mid = (left + right) / 2;
//            if(A[mid] < num)    {
//                left = mid + 1;
//            } else  {
//                right = mid - 1;
//            }
//        }
//
//        return left;
//    }
//
//    private static void input() throws IOException {
//        N = Integer.parseInt(br.readLine());
//        A = new int[N + 1];
//
//        st = new StringTokenizer(br.readLine());
//        for(int i = 1; i <= N; i++) {
//            A[i] = Integer.parseInt(st.nextToken());
//        }
//
//        M = Integer.parseInt(br.readLine());
//        B = new int[M + 1];
//
//        st = new StringTokenizer(br.readLine());
//        for(int i = 1; i <= M; i++) {
//            B[i] = Integer.parseInt(st.nextToken());
//        }
//    }
//}
