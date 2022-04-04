package programmers.kakao;

/**
 * 멀쩡한 사각형
 * https://programmers.co.kr/learn/courses/30/lessons/62048?language=java
 */
public class HypocriticalSquare {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;

        System.out.println(solution(w, h));
    }

    private static long solution(int w, int h) {
        long answer = w * h;
        long waste = 0;

        if(w == 1 || h == 1)    {
            return 0;
        }



        return answer - waste;
    }
}
