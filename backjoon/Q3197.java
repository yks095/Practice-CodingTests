package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백조의 호수
 * https://www.acmicpc.net/problem/3197
 */
public class Q3197 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Queue<Node> waterQueue = new LinkedList<>();
    static int R, C;
    static Node[][] lake;
    static Node[] swan;
    static boolean[][] isLakeVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int day = 0;

    static class Node   {
        int x;
        int y;
        String val;

        public Node(int x, int y, String val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        // 백조가 만날때 까지 얼음 녹이기
        while(!isSwanMeet_BFS()) {
            meltIce_BFS();
            day++;
        }

        System.out.println(day);
    }

    // 백조끼리 말날 수 있는지 BFS
    private static boolean isSwanMeet_BFS() {
        printLake(day);

        Queue<Node> queue = new LinkedList<>();
        boolean[][] isSwanVisited = new boolean[R][C];
        queue.add(swan[0]);

        isSwanVisited[swan[0].x][swan[0].y] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < dx.length; i++)  {
                int newX = node.x + dx[i];
                int newY = node.y + dy[i];

                if(newX < 0 || newY < 0 || newX >= R || newY >= C)  {
                    continue;
                }

                if(lake[newX][newY].val.equals("X"))    {
                    continue;
                }

                if(isSwanVisited[newX][newY])   {
                    continue;
                }

                if(!isSwanVisited[newX][newY]
                        && lake[newX][newY].val.equals("L")
                        && newX == swan[1].x
                        && newY == swan[1].y)    {
                    return true;
                } else  {
                    isSwanVisited[newX][newY] = true;
                    queue.add(new Node(newX, newY, "."));
                }
            }
        }

        return false;
    }

    // 얼음 녹이기 BFS
    private static void meltIce_BFS() {
        Queue<Node> tempQueue = new LinkedList<>();

        while(!waterQueue.isEmpty())    {
            Node node = waterQueue.poll();

            for(int i = 0; i < dx.length; i++)  {
                int newX = node.x + dx[i];
                int newY = node.y + dy[i];

                if(newX < 0 || newY < 0 || newX >= R || newY >= C)  {
                    continue;
                }

                if(isLakeVisited[newX][newY])   {
                    continue;
                }

                if(lake[newX][newY].val.equals("X") && !isLakeVisited[newX][newY])    {
                    isLakeVisited[newX][newY] = true;
                    lake[newX][newY].setVal(".");
                    tempQueue.add(new Node(newX, newY, "."));
                }
            }
        }

        waterQueue = new LinkedList<>(tempQueue);
    }

    private static void input() throws IOException {
        int swanIdx = 0;
        String firstLine = br.readLine();
        R = Integer.parseInt(firstLine.split("\\s+")[0]);
        C = Integer.parseInt(firstLine.split("\\s+")[1]);
        lake = new Node[R][C];
        isLakeVisited = new boolean[R][C];
        swan = new Node[2];

        for(int i = 0; i < R; i++)  {
            String line = br.readLine();
            for(int j = 0; j < C; j++)  {
                lake[i][j] = new Node(i, j, String.valueOf(line.charAt(j)));

                if("L".equals(lake[i][j].val))  {
                    swan[swanIdx++] = new Node(i, j, "L");
                }

                if(".".equals(lake[i][j].val))  {
                    waterQueue.add(lake[i][j]);
                    isLakeVisited[i][j] = true;
                }
            }
        }
    }

    private static void printSwan(int k) {
        System.out.println("\n[print swan] : " + k);
        for(int i = 0; i < swan.length; i++)    {
            System.out.println("swan" + i + " : [" + swan[i].x + ", " + swan[i].y + "] = " + swan[i].val);
        }
    }

    private static void printLake(int k) {
        System.out.println("\n[print lake] : " + k);
        for(int i = 0; i < R; i++)  {
            for(int j = 0; j < C; j++)  {
                System.out.print(lake[i][j].val + " ");
            }
            System.out.println();
        }
    }
}
