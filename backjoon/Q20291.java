package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 파일 정리
 * https://www.acmicpc.net/problem/20291
 */
public class Q20291 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Integer> extensionMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static int N;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++)  {
            String ext = br.readLine().split("\\.")[1];
            extensionMap.put(ext, extensionMap.get(ext) == null ? 1 : extensionMap.get(ext) + 1);
        }

        List<String> keyList = new ArrayList<>(extensionMap.keySet());
        Collections.sort(keyList);

        for (String key : keyList) {
            sb.append(key).append(" ").append(extensionMap.get(key)).append("\n");
        }

        System.out.println(sb);
    }
}
