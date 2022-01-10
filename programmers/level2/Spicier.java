//package programmers.level2;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * 더 맵게
// * https://programmers.co.kr/learn/courses/30/lessons/42626?language=java
// */
//public class Spicier {
//    public static void main(String[] args) {
//        int[] scoville = {1, 1, 2};
//        int K = 3;
//
//        System.out.println(solution(scoville, K));  // 2
//    }
//
//    private static int solution(int[] scoville, int K) {
//        int answer = 0;
//        List<Integer> list = new ArrayList<>();
//        int num;
//
//        for(int i : scoville)   {
//            if(i < K)   {
//                list.add(i);
//            }
//        }
//
//        if(list.size() == 1)    {
//            return -1;
//        }
//
//        // 만약 리스트에 1개의 값만 남았고, K보다 작다면 -1반환
//        while(!list.isEmpty() && (list.size() != 1 || list.get(0) >= K)) {
//            // list 정렬
//            Collections.sort(list);
//            // 가장 낮은 두개의 스코빌 지수 계산
//            num = list.get(0) + (list.get(1) * 2);
//            answer++;
//
//            // 만약 계산된 값이 K보다 작다면 list에 추가
//            if(num < K) {
//                list.add(num);
//            }
//            list.remove(list.get(1));
//            list.remove(list.get(0));
//        }
//
//        if(list.size() == 1 && list.get(0) < K) {
//            return -1;
//        }
//        return answer;
//    }
//}
