package programmers.level1;

/**
 * 가운데 글자 가져오기
 * https://programmers.co.kr/learn/courses/30/lessons/12903
 */
public class MiddleString {
    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        int length = s.length();

        if(length % 2 == 1) {
            return String.valueOf(s.charAt(length / 2));
        } else  {
            return s.substring(length / 2 - 1, length / 2 + 1);
        }
    }
}
