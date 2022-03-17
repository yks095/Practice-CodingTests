package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백조의 호수
 * https://www.acmicpc.net/problem/3197
 */
public class Q3197 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();
        int R = Integer.parseInt(firstLine.split("\\s+")[0]);
        int C = Integer.parseInt(firstLine.split("\\s+")[1]);

        String[][] map = new String[R][C];

        for(int i = 0; i < R; i++)  {
            String input = br.readLine();
            for(int j = 0; j < C; j++)  {
                map[i][j] = String.valueOf(input.charAt(j));
            }
        }


    }
}
