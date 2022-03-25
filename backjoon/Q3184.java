package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 양
 * https://www.acmicpc.net/problem/3184
 */
public class Q3184 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R;
    static int C;
    static String[][] map;
    static boolean[][] isVisited;
    static int tmpSheep;
    static int tmpWolf;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();

        int sheep = 0;
        int wolf = 0;

        for(int i = 0; i < R; i++)  {
            for(int j = 0; j < C; j++)  {
                if(Arrays.asList(".", "v", "o").contains(map[i][j]) && !isVisited[i][j])   {
                    tmpSheep = 0;
                    tmpWolf = 0;

                    bfs(i, j);

                    if(tmpSheep > tmpWolf)  {
                        sheep += tmpSheep;
                    } else  {
                        wolf += tmpWolf;
                    }
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    private static void bfs(int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        isVisited[i][j] = true;
        countAnimal(i, j);

        while(!queue.isEmpty()) {
            int a = queue.poll();
            int b = queue.poll();

            for(int k = 0; k < dx.length; k++)  {
                int x = a + dx[k];
                int y = b + dy[k];

                if(x < 0 || y < 0 || x >= R || y >= C)  {
                    continue;
                }
                if(isVisited[x][y]) {
                    continue;
                }
                if(map[x][y].equals("#"))   {
                    continue;
                }

                isVisited[x][y] = true;
                queue.add(x);
                queue.add(y);
                countAnimal(x, y);
            }
        }
    }

    private static void countAnimal(int i, int j) {
        if(map[i][j].equals("v"))   {
            tmpWolf++;
        } else if(map[i][j].equals("o"))    {
            tmpSheep++;
        }
    }

    private static void input() throws IOException {
        String firstLine = br.readLine();
        R = Integer.parseInt(firstLine.split("\\s+")[0]);
        C = Integer.parseInt(firstLine.split("\\s+")[1]);
        map = new String[R][C];
        isVisited = new boolean[R][C];

        for(int i = 0; i < R; i++)  {
            String line = br.readLine();
            for(int j = 0; j < C; j++)  {
                map[i][j] = String.valueOf(line.charAt(j));
            }
        }
    }
}
