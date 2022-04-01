package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 듣보잡
 * https://www.acmicpc.net/problem/1764
 */
public class Q1764 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();

        List<String> results = new ArrayList<>();
        for (String name : map.keySet()) {
            if(map.get(name) == 2)  {
                results.add(name);
            }
        }

        Collections.sort(results);
        sb.append(results.size()).append("\n");
        for (String result : results) {
            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }

    private static void input() throws IOException {
        String firstLine = br.readLine();
        N = Integer.parseInt(firstLine.split("\\s+")[0]);
        M = Integer.parseInt(firstLine.split("\\s+")[1]);

        for(int i = 0; i < N; i++)  {
            String lookName = br.readLine();
            map.put(lookName, map.get(lookName) == null ? 1 : map.get(lookName) + 1);
        }

        for(int i = 0; i < M; i++)  {
            String seeName = br.readLine();
            map.put(seeName, map.get(seeName) == null ? 1 : map.get(seeName) + 1);
        }
    }
}
