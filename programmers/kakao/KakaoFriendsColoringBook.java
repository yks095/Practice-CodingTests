package programmers.kakao;

/**
 * 카카오프렌즈 컬러링북
 * https://programmers.co.kr/learn/courses/30/lessons/1829?language=java
 */
public class KakaoFriendsColoringBook {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {     // 4, 5
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

//        int[][] picture = {     // 2, 6
//                {1, 1, 1, 0},
//                {1, 1, 1, 0},
//                {0, 0, 0, 1},
//                {0, 0, 0, 1},
//                {0, 0, 0, 1},
//                {0, 0, 0, 1}
//        };



        int[] answer = solution(m, n, picture);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    static int currentNumber;
    static int currentAreaCount;
    static int maxAreaSizeCount;
    static int areaCount;
    static boolean[][] isVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static int[] solution(int m, int n, int[][] picture) {
        areaCount = 0;
        maxAreaSizeCount = Integer.MIN_VALUE;
        isVisited = new boolean[m][n];

        for(int i = 0; i < m; i++)  {
            for(int j = 0; j < n; j++)  {
                if(picture[i][j] != 0 && !isVisited[i][j]) {
                    currentAreaCount = 1;
                    currentNumber = picture[i][j];
                    dfs(i, j, picture);
                    areaCount++;
                    currentNumber = Integer.MIN_VALUE;

                    if(currentAreaCount > maxAreaSizeCount) {
                        maxAreaSizeCount = currentAreaCount;
                    }
                }
            }
        }

        return new int[]{areaCount, maxAreaSizeCount};
    }

    private static void dfs(int i, int j, int[][] picture) {
        isVisited[i][j] = true;

        for(int k = 0; k < dx.length; k++)  {
            int x = i + dx[k];
            int y = j + dy[k];

            if(x < 0 || y < 0 || x >= picture.length || y >= picture[0].length) continue;
            if(isVisited[x][y]) continue;
            if(picture[x][y] != currentNumber) continue;

            System.out.println("x : " + x + ", y : " + y);

            currentAreaCount++;
            dfs(x, y, picture);
        }
    }
}
