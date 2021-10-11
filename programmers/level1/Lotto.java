package programmers.level1;

/**
 * 로또의 최고 순위와 최저 순위
 * https://programmers.co.kr/learn/courses/30/lessons/77484?language=java
 */
public class Lotto {

    public static void main(String[] args) {
        int[] lotto = {44, 1, 0, 0, 31, 25};
        int[] winNum = {31, 10, 45, 1, 6, 19};

        int[] answer = solution(lotto, winNum);
        for(int i = 0; i < answer.length; i++)  {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(int[] lotto, int[] winNum) {
        int[] answer = {};
        int correctCnt = 0;
        int zeroCnt = 0;

        for (int k : lotto) {
            if (k == 0) {
                zeroCnt++;
            } else {
                for (int i : winNum) {
                    if (i == k) {
                        correctCnt++;
                        break;
                    }
                }
            }
        }

        return getGrade(answer, correctCnt, zeroCnt);
    }

    private static int[] getGrade(int[] answer, int correctCnt, int zeroCnt) {
        switch (correctCnt) {
            case 6: answer = new int[]{1, 1}; break;
            case 5: answer = new int[]{2 - zeroCnt, 2}; break;
            case 4: answer = new int[]{3 - zeroCnt, 3}; break;
            case 3: answer = new int[]{4 - zeroCnt, 4}; break;
            case 2: answer = new int[]{5 - zeroCnt, 5}; break;
            case 1: answer = new int[]{6 - zeroCnt, 6}; break;
            case 0:
                if(zeroCnt == 0)    {
                    zeroCnt++;
                }
                answer = new int[]{7 - zeroCnt, 6}; break;
        }
        return answer;
    }
}
