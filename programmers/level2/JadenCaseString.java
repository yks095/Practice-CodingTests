package programmers.level2;


import java.util.Locale;

/**
 * JadenCase 문자열 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12951?language=java
 */
public class JadenCaseString {
    public static void main(String[] args) {
        String s = "adgagd 3eagdag ";
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase(Locale.ROOT);

        for(char c : s.toCharArray()) {
            if(c == ' ')    {
                isFirst = true;
            } else  {
                if(isFirst && c <= 'z' && c >= 'a') {
                    c = (char) (c - 32);
                }
                isFirst = false;
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
