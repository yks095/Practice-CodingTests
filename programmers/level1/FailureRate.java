package programmers.level1;

import java.util.*;

/**
 * 실패율
 * https://programmers.co.kr/learn/courses/30/lessons/42889?language=java
 */
public class FailureRate {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] solution = solution(N, stages);

        for(int i : solution)   {       // 3,4,2,1,5
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int N, int[] stages) {
        int[] arr = new int[N];
        Map<Integer, Double> map = new HashMap<>();

        // 1 ~ N+1 까지 Map 에 추가
        for(int i = 1; i <= N + 1; i++) {
            map.put(i, 0.0);
        }

        // 각 스테이지 마다 머무르고 있는 사용자 수 저장
        int count = stages.length;
        for (int stage : stages) {
            map.put(stage, map.get(stage) + 1);
        }

        // 각 스테이지 마다 실패율 저장
        for(int i : map.keySet())   {
            double tmp = map.get(i);
            map.put(i, map.get(i) / count);
            count -= tmp;
        }

        // 실패율 별로 정렬(실패율이 같을 시에는 key값 오름차순으로)
        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> {
            double d = o2.getValue() - o1.getValue();

            if(d < 0)   {
                return -1;
            } else if(d > 0)    {
                return 1;
            } else {
                return o1.getKey() - o2.getKey();
            }

        });

        int i = 0;
        for(Map.Entry<Integer, Double> entry : entryList){
            if(entry.getKey() == N + 1) {
                continue;
            }
            arr[i++] = entry.getKey();
        }

        return arr;
    }
}
