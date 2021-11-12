package programmers.level1;

/**
 * 문자열 다루기 기본
 * https://programmers.co.kr/learn/courses/30/lessons/12918?language=java
 */
public class HandelString {
    public static void main(String[] args) {
        String s = "a234";
        System.out.println(solution(s));
    }

    private static boolean solution(String s) {
        try {
            return (s.length() == 4 || s.length() == 6) && Integer.parseInt(s) <= 999999;
        } catch (NumberFormatException e)   {
            return false;
        }

    }
}
