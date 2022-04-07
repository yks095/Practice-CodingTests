package programmers.kakao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 거리두기 확인하기
 * https://programmers.co.kr/learn/courses/30/lessons/81302?language=java
 */
public class CheckDistancing {
    public static void main(String[] args) {
        String[][] places = {
                {
                    "POOOP",
                    "OXXOX",
                    "OPXPX",
                    "OOXOX",
                    "POXXP"
                },
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] result = solution(places);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static String[][] room;
    static boolean[][] isVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static int[] solution(String[][] places) {
        int[] result = new int[places.length];
        for(int i = 0; i < places.length; i++)  {
            result[i] = checkIsDistancing(places[i]);
        }

        return result;
    }

    private static int checkIsDistancing(String[] place) {
        initRoom(place);
        printRoom();

        for(int i = 0; i < 5; i++)  {
            for(int j = 0; j < 5; j++)  {
                if("P".equals(room[i][j]) && !isVisited[i][j])  {
                    if(!bfs(i, j))  {
                        return 0;
                    }
                }
            }
        }

        return 1;
    }

    private static boolean bfs(int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        queue.offer(j);

        isVisited[i][j] = true;

        while(!queue.isEmpty()) {
            int di = queue.poll();
            int dj = queue.poll();

            for(int k = 0; k < dx.length; k++)  {
                int x = di + dx[k];
                int y = dj + dy[k];
                int manhattanDistance = getDistance(i, j, x, y);

                if(x < 0 || y < 0 || x >= 5 || y >= 5)  continue;
                if(x == i && y == j)    {
                    continue;
                }
                if(isVisited[x][y]) continue;
                if("X".equals(room[x][y]))  continue;
                if("P".equals(room[x][y]) && manhattanDistance <= 2) {
                    System.out.println("i : " + i + ", j : " + j);
                    System.out.println("x : " + x + ", y : " + y);

                    return false;
                }

                if("O".equals(room[x][y]) && manhattanDistance < 2) {
                    queue.add(x);
                    queue.add(y);
                    isVisited[x][y] = true;
                }

            }
        }

        return true;
    }

    private static void printRoom() {
        for(int i = 0; i < 5; i++)  {
            System.out.println();
            for(int j = 0; j < 5; j ++) {
                System.out.print(room[i][j] + " ");
            }
        }

        System.out.println();
    }

    private static void initRoom(String[] place) {
        room = new String[5][5];
        isVisited = new boolean[5][5];

        for(int i = 0; i < place.length; i++)   {
            String str = place[i];
            for(int j = 0; j < place[i].length(); j++)  {
                room[i][j] = String.valueOf(str.charAt(j));
            }
        }
    }

    private static int getDistance(int x1, int y1, int x2, int y2)   {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}
