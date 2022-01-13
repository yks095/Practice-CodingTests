package programmers.level2;

/**
 * 짝지어 제거하기
 * https://programmers.co.kr/learn/courses/30/lessons/12973?language=java
 */
public class RemovePair {
    public static void main(String[] args) {
        String s = "baabaa";

        System.out.println(solution(s));
    }

    private static boolean solution(String s) {
        StringBuilder sb = new StringBuilder(s);

        for(int i = 1; i < s.length(); i++) {
            if(sb.charAt(i - 1) == sb.charAt(i))  {
                System.out.println(i + " before : " + sb.toString());
                sb.deleteCharAt(i - 1);
                sb.deleteCharAt(i - 1);
                System.out.println(i + " after : " + sb.toString());
                System.out.println();
                i = 1;
            }
        }

        return true;
    }
}
