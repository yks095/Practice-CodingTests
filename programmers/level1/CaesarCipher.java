package programmers.level1;

/**
 * 시저 암호
 * https://programmers.co.kr/learn/courses/30/lessons/12926?language=java
 */
public class CaesarCipher {
    public static void main(String[] args) {
        String s = "a B z";
        int n = 4;
        System.out.println(solution(s, n));
    }

    private static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String str = "";
            if(c == ' ')    {
                str = " ";
            } else if((int)c >= 65 && (int)c <= 90) {
                int num = (int)c + n;
                int num2 = num % 90;
                int tmp = num > 90 ? 64 + num2 : num;

                str = String.valueOf((char) (tmp));
            } else if((int)c >= 97 && (int)c <= 122)    {
                int num = (int)c + n;
                int num2 = num % 122;
                int tmp = num > 122 ? 96 + num2 : num;

                str = String.valueOf((char) (tmp));
            }

            sb.append(str);
        }

        return sb.toString();


    }
}
