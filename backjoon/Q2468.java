package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 안전 영역
 * https://www.acmicpc.net/problem/2468
 */
public class Q2468 {

    static int[][] area;
    static boolean[][] isVisited;

    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        int max = 0;

        for(int i = 0; i < area.length; i++)    {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < area[i].length; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if(max < area[i][j])   {
                    max = area[i][j];
                }
            }
        }

        int maxCount = 0;

        for(int height = 0; height <  max + 1; height++)   {
            int count = 0;
            isVisited = new boolean[N][N];

            for(int i = 0; i < N; i++)  {
                for(int j = 0; j < N; j++)  {
                    if(area[i][j] > height && !isVisited[i][j]) {
                        count += dfs(i, j, height);
                    }
                }
            }

            maxCount = Math.max(count, maxCount);
        }

        System.out.println(maxCount);
    }

    private static int dfs(int i, int j, int height) {
        isVisited[i][j] = true;

        for(int k = 0; k < dx.length; k++)  {
            int x = i + dx[k];
            int y = j + dy[k];

            if(x < 0 || y < 0 || x > N - 1 || y > N - 1)    {
                continue;
            }

            if(isVisited[x][y]) {
                continue;
            }

            if(area[x][y] > height) {
                dfs(x, y, height);
            }
        }

        return 1;
    }
}
