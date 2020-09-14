package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q18868 {
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("\\s+");
        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);
        int count = 0;

        for(int i = 0; i < M; i++)  {
            ArrayList<Integer> space = getRankedArrayList(br.readLine(), N);
            arrayList.add(space);
        }

        br.close();
        System.out.println(arrayList);

        for(int i = 0; i < arrayList.size(); i++)   {
            for(int j = i + 1; j < arrayList.size(); j++)   {
                if(Arrays.equals(arrayList.get(i).toArray(), arrayList.get(j).toArray()))    {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    private static ArrayList<Integer> getRankedArrayList(String readLine, int N) {
        System.out.println("ArrayList 생성");
        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] array = readLine.split("\\s+");
        int[] rank = new int[N];

        for(int i = 0; i < N; i++)   {
            for(int j = 0; j < N; j++)   {
                if(Integer.parseInt(array[i]) < Integer.parseInt(array[j])) {
                    rank[i]++;
                }
            }
        }

        System.out.println("array : " + Arrays.toString(array));
        System.out.println("rank : " + Arrays.toString(rank));

        for (int i = 0; i < rank.length; i++) {
            arrayList.add(i, rank[i]);
        }

        return arrayList;
    }
}

// reference : https://www.acmicpc.net/problem/18868 멀티버스