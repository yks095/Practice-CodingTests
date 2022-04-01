package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 화살표 그리기
 * https://www.acmicpc.net/problem/15970
 */
public class Q15970 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer>[] points;
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        input();

        for(int i = 1; i < points.length; i++) {
            Collections.sort(points[i]);
        }

        for(int i = 1; i < points.length; i++)  {
            List<Integer> list = points[i];
            int dist = list.get(1) - list.get(0);
            for(int j = 1; j < list.size(); j++)    {

            }
        }

//        for(int i = 1; i < 3; i++) {
//            System.out.println("color : " + i);
//            List<Integer> list = points[i];
//            for (Integer integer : list) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        points = new ArrayList[3];

        for(int i = 1; i < points.length; i++) {
            points[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++)  {
            String point = br.readLine();
            int value = Integer.parseInt(point.split("\\s+")[0]);
            int color = Integer.parseInt(point.split("\\s+")[1]);

            points[color].add(value);
        }
    }
}
