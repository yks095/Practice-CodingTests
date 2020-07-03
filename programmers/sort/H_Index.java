package programmers.sort;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int answer = solution(citations);

        System.out.println(answer);
    }

    public static int solution(int[] citations)  {
        int answer = 0;
        Arrays.sort(citations);     // 0, 1, 3, 5, 6

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
