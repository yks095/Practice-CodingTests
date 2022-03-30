//package backjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
///**
// * 연구소
// * https://www.acmicpc.net/problem/14502
// */
//public class Q14502 {
//
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//    static int map[][];
//    static int temp[][];
//    static int tempIdx = 0;
//    static int N, M;
//    static int wallCount = 3;
//    static int result = 0;
//
//    public static void main(String[] args) throws IOException {
//        input();
//
//        for(int i = 1; i <= N; i++) {
//            for(int j = 1; j <= M; j++) {
//                if(map[i][j] == 0)  {
//                    temp[++tempIdx][0] = i;
//                    temp[tempIdx][1] = j;
//                }
//            }
//        }
//
//        dfs(1, 0);
//
//        System.out.println(result);
//    }
//
//    private static void dfs(int i, int count) {
//        if(count == 3)  {
//            bfs(i);
//            return;
//        } else  {
//
//            if(i > temp.length) {
//                return;
//            }
//
//            map[temp[i][0]][temp[i][1]] = 1;
//            dfs(i + 1, count++);
//
//            map[temp[i][0]][temp[i][1]] = 0;
//            dfs(i + 1, count++);
//        }
//    }
//
//    private static void bfs(int i) {
//        Queue<Integer> queue = new LinkedList<>();
//        for(int a = 1; a <= N; a++) {
//            for(int b = 1; b <= M; b++) {
//                queue.add(te)
//            }
//        }
//    }
//
//    private static void input() throws IOException {
//        String firstLine = br.readLine();
//
//        N = Integer.parseInt(firstLine.split("\\s+")[0]);
//        M = Integer.parseInt(firstLine.split("\\s+")[1]);
//
//        map = new int[N + 1][M + 1];
//        temp = new int[N * M + 1][2];
//
//        for(int i = 1; i <= N; i++)  {
//            int j = 0;
//            st = new StringTokenizer(br.readLine());
//            while(st.hasMoreTokens())   {
//                int area = Integer.parseInt(st.nextToken());
//                map[i][++j] = area;
//            }
//        }
//    }
//}
