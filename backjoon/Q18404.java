package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 현명한 나이트
 * https://www.acmicpc.net/problem/18404
 */
public class Q18404 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] dest;
    static int[][] point = new int[2][2];
    static int N, M;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        point[0][0] = Integer.parseInt(st.nextToken());
        point[0][1] = Integer.parseInt(st.nextToken());

        dest = new int[N + 1][N + 1];
        bfs(point[0][0], point[0][1]);

        for(int i = 0; i < M; i++)  {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(dest[x][y]).append(" ");
        }

        System.out.println(sb);

    }

    private static void bfs(int a, int b) {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                dest[i][j] = -1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        queue.add(b);
        dest[a][b] = 0;

        while(!queue.isEmpty()) {
            int tmp_x = queue.poll();
            int tmp_y = queue.poll();
            for(int k = 0; k < dx.length; k++)  {
                int x = tmp_x + dx[k];
                int y = tmp_y + dy[k];

                if(x < 1 || y < 1 || x > N || y > N)    {
                    continue;
                }

                if(dest[x][y] != -1)    {
                    continue;
                }

                queue.add(x);
                queue.add(y);

                dest[x][y] = dest[tmp_x][tmp_y] + 1;
            }
        }
    }


}
