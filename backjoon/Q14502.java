package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연구소
 * https://www.acmicpc.net/problem/14502
 */
public class Q14502 {

    static StringTokenizer st;
    static int map[][];
    static int wallCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();

        int N = Integer.parseInt(firstLine.split("\\s+")[0]);
        int M = Integer.parseInt(firstLine.split("\\s+")[1]);

        map = new int[N][M];

        for(int i = 0; i < N; i++)  {
            int j = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens())   {
                int area = Integer.parseInt(st.nextToken());
                map[i][j++] = area;
            }
        }

        for(int i = 0; i < N; i++)  {
            wallCount = 0;
            for(int j = 0; j < M; j++)  {
                if(map[i][j] == 0)  {
                    map[i][j] = 1;
                }
            }
        }


//        for(int i = 0; i < N; i++)  {
//            System.out.println();
//            for(int j = 0; j < M; j++)  {
//                System.out.print(map[i][j] + " ");
//            }
//        }


    }
}
