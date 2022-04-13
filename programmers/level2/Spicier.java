package programmers.level2;

import java.util.PriorityQueue;

/**
 * 더 맵게
 * https://programmers.co.kr/learn/courses/30/lessons/42626?language=java
 */
public class Spicier {
    public static void main(String[] args) {
        int[] scoville = {1, 1, 2};
        int K = 3;

        System.out.println(solution(scoville, K));  // 2
    }

    private static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int i : scoville) {
            queue.offer((long) i);
        }

        while (queue.peek() < (long) K)   {
            long first = queue.poll();
            long second = queue.poll();

            long mixed = first + (second * 2);
            queue.offer(mixed);
            answer++;

            if(queue.size() == 1 && queue.peek() < K)   {
                return -1;
            }
        }

        return answer;
    }
}
