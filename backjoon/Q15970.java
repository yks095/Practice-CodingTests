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

        for(int i = 1; i <= N; i++) {
            Collections.sort(points[i]);
        }

        for(int i = 1; i <= N; i++)  {
            for(int j = 0; j < points[i].size(); j++)    {
                int leftDist = getLeftDistance(i, j);
                int rightDist = getRightDistance(i, j);

                result += Math.min(leftDist, rightDist);
            }

        }

        System.out.println(result);
    }

    private static int getRightDistance(int i, int j) {
        if(j == points[i].size() - 1)  {
            return Integer.MAX_VALUE;
        } else  {
            return points[i].get(j + 1) - points[i].get(j);
        }
    }

    private static int getLeftDistance(int i, int j) {
        if(j == 0)  {
            return Integer.MAX_VALUE;
        } else  {
            return points[i].get(j) - points[i].get(j - 1);
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        points = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
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
