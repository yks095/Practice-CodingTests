package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 나이트의 이동
 * https://www.acmicpc.net/problem/7562
 */
public class Q7562 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[][] map;
    static int[][] dest;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[][] point;
    static int L;
    static int min;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while(T-- != 0) {
            input();

            bfs(point[0][0], point[0][1]);

            sb.append(dest[point[1][0]][point[1][1]]).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int i, int j) {
        for(int a = 0; a < L; a++)  {
            for(int b = 0; b < L; b++)  {
                dest[a][b] = -1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        dest[i][j] = 0;

        while(!queue.isEmpty()) {
            int a = queue.poll();
            int b = queue.poll();

            for(int k = 0; k < dx.length; k++)  {
                int x = a + dx[k];
                int y = b + dy[k];

                if(x < 0 || y < 0 || x >= L || y >= L)  {
                    continue;
                }

                if(dest[x][y] != -1)    {
                    continue;
                }

                queue.add(x);
                queue.add(y);
                dest[x][y] = dest[a][b] + 1;
            }
        }
    }

    private static void input() throws IOException {
        min = Integer.MAX_VALUE;
        point = new int[2][2];
        L = stringToInteger(br.readLine());

        map = new String[L][L];
        dest = new int[L][L];

        for(int i = 0; i < 2; i++)  {
            st = new StringTokenizer(br.readLine());
            point[i] = new int[]{stringToInteger(st.nextToken()), stringToInteger(st.nextToken())};
        }
    }

    private static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }
}
