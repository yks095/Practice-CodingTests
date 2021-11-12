package programmers.level1;

/**
 * 문자열 내 p와 y의 개수
 * https://programmers.co.kr/learn/courses/30/lessons/12916?language=java
 */
public class CountP_Y {
    public static void main(String[] args) {
        String s = "pPoooY";
        System.out.println(solution(s));
    }

    private static boolean solution(String s) {
        int countP = 0;
        int countY = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'p' || c == 'P')    {
                countP++;
            } else if(c == 'y' || c == 'Y') {
                countY++;
            }
        }

        return countP == countY;
    }
}
