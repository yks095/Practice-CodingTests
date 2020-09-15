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

        String[] inputs = br.readLine().split("\\s+");                                      // 우주의 갯수 M, 행성의 갯수 N을 입력 받음
        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);
        int count = 0;

        for(int i = 0; i < M; i++)  {                                                             // 우주의 갯수 만큼 for문을 반복하며 한 바퀴 돌 때마다 우주의 행성 크기 입력 받음
            String[] array = br.readLine().split("\\s+");
            ArrayList<Integer> space = getRankedArrayList(array, N);                              // 배열 내 값들의 순위를 매겨줄 메소드 호출
            arrayList.add(space);
        }

        br.close();
        System.out.println(arrayList);

        for(int i = 0; i < arrayList.size(); i++)   {
            for(int j = i + 1; j < arrayList.size(); j++)   {
                if(Arrays.equals(arrayList.get(i).toArray(), arrayList.get(j).toArray()))    {     // 순위가 같은 배열이 ArrayList에 있다면 count 증가
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    private static ArrayList<Integer> getRankedArrayList(String[] array, int N) {                // 배열 내의 값들의 순위를 매긴 ArrayList를 반환해주는 메소드
        System.out.println("ArrayList 생성");
        ArrayList<Integer> arrayList = new ArrayList<>();
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

        for (int i = 0; i < rank.length; i++) {                                                  // 입력 받은 우주에 있는 행성의 크기에 따라 순위를 매겨 줌
            arrayList.add(i, rank[i]);
        }

        return arrayList;
    }
}

// reference : 멀티버스 (https://www.acmicpc.net/problem/18868)