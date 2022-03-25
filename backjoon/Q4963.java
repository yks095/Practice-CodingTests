package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 섬의 개수
 * https://www.acmicpc.net/problem/4963
 */
public class Q4963 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] isVisited;
    static int w = -1;
    static int h = -1;
    static int result;
    static int dx[] = {1, 0, -1, 0, 1, 1, -1, -1};
    static int dy[] = {0, 1, 0, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        while(w != 0 && h != 0) {
            input();

            for(int i = 0; i < h; i++)  {
                for(int j = 0; j < w; j++)  {
                    if(map[i][j] == 1 && !isVisited[i][j])  {
                        bfs(i, j);
                        result++;
                    }
                }
            }

            sb.append(result).append("\n");
        }

        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        result = 0;

        map = new int[h][w];
        isVisited = new boolean[h][w];

        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void bfs(int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        isVisited[i][j] = true;

        while(!queue.isEmpty()) {
            int a = queue.poll();
            int b = queue.poll();

            for(int k = 0; k < dx.length; k++)  {
                int x = a + dx[k];
                int y = b + dy[k];

                if(x < 0 || y < 0 || x >= h || y >= w)  {
                    continue;
                }
                if(isVisited[x][y]) {
                    continue;
                }
                if(map[x][y] == 1)  {
                    isVisited[x][y] = true;
                    queue.add(x);
                    queue.add(y);
                }
            }
        }
    }
}
