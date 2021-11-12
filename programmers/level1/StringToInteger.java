package programmers.level1;

/**
 * 문자열을 정수로 바꾸기
 * https://programmers.co.kr/learn/courses/30/lessons/12925?language=java
 */
public class StringToInteger {
    public static void main(String[] args) {
        String s = "1234";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        if(s.charAt(0) == '-')  {
            return  -1 * Integer.parseInt(s.substring(1));
        } else if(s.charAt(0) == '+')   {
            return Integer.parseInt(s.substring(1));
        } else  {
            return Integer.parseInt(s);
        }
    }
}
