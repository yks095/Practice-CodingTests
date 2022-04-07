package programmers.kakao;

import java.util.ArrayList;
import java.util.List;

/**
 * [1차] 프렌즈4블록
 * https://programmers.co.kr/learn/courses/30/lessons/17679
 */
public class Friends4Block {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {
                "CCBDE",
                "AAADE",
                "AAABF",
                "CCBBF"
        };

//        int n = 6;
//        int m = 6;
//        String[] board = {
//                "TTTANT",
//                "RRFACC",
//                "RRRFCC",
//                "TRRRAA",
//                "TTMMMF",
//                "TMMTTJ"
//        };

        System.out.println(solution(m, n, board));
    }

    static String[][] map;
    static int[][] erasedBlock;
    static int[][] availableEraseBlock;
    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};
    static int count = 0;

    private static int solution(int m, int n, String[] board) {
        initData(m, n, board);

        while (availableErase(m, n)) {
            erase();
            printStringArray(map);
        }

        return count;
    }

    private static boolean availableErase(int m, int n) {
        int availableCount = 0;
        availableEraseBlock = new int[m][n];

        // TODO 2*2 의 캐릭터들의 갯수를 파악
        for(int i = 0; i < m; i++)  {
            for(int j = 0; j < n; j++)  {
                String str = map[i][j];
                if(!"-1".equals(str) && checkSquare(str, i, j))  {
                    availableEraseBlock[i][j] = 1;
                    availableEraseBlock[i + 1][j] = 1;
                    availableEraseBlock[i][j + 1] = 1;
                    availableEraseBlock[i + 1][j + 1] = 1;
                    availableCount++;
                }
            }
        }

        // TODO 갯수가 1이상이면 true, 0이면 false
        return availableCount >= 1;
    }

    private static boolean checkSquare(String str, int i, int j) {
        for(int k = 0; k < dx.length; k++)  {
            int x = i + dx[k];
            int y = j + dy[k];

            if(x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
                return false;
            }

            if(!str.equals(map[x][y]))  {
                return false;
            }
        }

        return true;
    }

    private static void erase() {
        // TODO availableErase()에서 찾은 지울 수 있는 값들을 지우고 특정 자료구조에 저장
        for(int i = 0; i < availableEraseBlock.length; i++) {
            for(int j = 0; j < availableEraseBlock[i].length; j++)  {
                if(availableEraseBlock[i][j] == 1)  {
                    count++;
                    map[i][j] = "-1";
                }
            }
        }

        // TODO 지워진 캐릭터 위에 존재하는 캐릭터들을 내림
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++)  {
                if("-1".equals(map[i][j]))  {
                    stepDown(i, j);
                }
            }
        }
    }

    private static void stepDown(int i, int j) {
        List<String> temp = new ArrayList<>();
        for(int k = i - 1; k >= 0; k--) {
            if(!"-1".equals(map[k][j])) {
                temp.add(map[k][j]);
                map[k][j] = "-1";
            }
        }

        for(int k = 0; k < temp.size(); k++)    {
            map[i - k][j] = temp.get(k);
        }
    }

    private static void initData(int m, int n, String[] board) {
        map = new String[m][n];

        for(int i = 0; i < m; i++)  {
            String str = board[i];
            for(int j = 0; j < n; j++)  {
                map[i][j] = String.valueOf(str.charAt(j));
            }
        }
    }

    private static void printIntArray(int[][] intArray) {
        System.out.println("\nInt Array");
        for(int i = 0; i < intArray.length; i++)  {
            for(int j = 0; j < intArray[i].length; j++) {
                System.out.print(intArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printStringArray(String[][] stringArray) {
        System.out.println("\nString Array");
        for(int i = 0; i < stringArray.length; i++)  {
            for(int j = 0; j < stringArray[i].length; j++) {
                System.out.print(stringArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
