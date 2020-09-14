package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        br.close();

        int P1 = Integer.parseInt(st.nextToken());
        int P2 = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        while(((X <= 10000) || (Y <= 10000)) && X != Y)   {
            if(X > Y)   {
                Y += P2;
            }
            else {
                X += P1;
            }
        }

        if(X >= 10000 || Y >= 10000)    {
            System.out.println(-1);
        }
        else    {
            System.out.println(X);
        }
    }
}

// reference : https://www.acmicpc.net/problem/18512 점프 점프
