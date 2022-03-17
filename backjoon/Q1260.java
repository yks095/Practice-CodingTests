package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * DFS와 BFS
 * https://www.acmicpc.net/problem/1260
 */
public class Q1260 {

    static int[][] map;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();
        int N = Integer.parseInt(firstLine.split("\\s+")[0]);
        int M = Integer.parseInt(firstLine.split("\\s+")[1]);
        int V = Integer.parseInt(firstLine.split("\\s+")[2]);

        map = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++)  {
            String line = br.readLine();
            int x = Integer.parseInt(line.split("\\s+")[0]);
            int y = Integer.parseInt(line.split("\\s+")[1]);

            map[x][y] = 1;
            map[y][x] = 1;
        }

        isVisited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        isVisited = new boolean[N + 1];
        bfs(V);
    }

    private static void dfs(int V) {
        System.out.print(V + " ");
        isVisited[V] = true;

        for(int i = 1; i < map.length; i++)    {
            if(map[V][i] == 1 && !isVisited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int V) {
        System.out.print(V + " ");

        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        isVisited[V] = true;

        while(!queue.isEmpty()) {
            int poll = queue.poll();

            for(int i = 1; i < map.length; i++) {
                if(map[poll][i] == 1 && !isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
