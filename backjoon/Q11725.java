package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 트리의 부모 찾기
 * https://www.acmicpc.net/problem/11725
 */
public class Q11725 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static ArrayList<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        input();

        dfs(1, 0);

        for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int node, int p) {
        for(int n : tree[node]) {
            if(n == p) {
                continue;
            }

            parent[n] = node;
            dfs(n, node);
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        parent = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            String line = br.readLine();
            int x = Integer.parseInt(line.split("\\s+")[0]);
            int y = Integer.parseInt(line.split("\\s+")[1]);

            tree[x].add(y);
            tree[y].add(x);
        }
    }
}
