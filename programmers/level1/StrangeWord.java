package programmers.level1;

import java.util.Locale;

/**
 * 이상한 문자 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12930?language=java
 */
public class StrangeWord {
    public static void main(String[] args) {
        String s = "tr h world";
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            String tmp;
            if(s.charAt(i) == ' ')  {
                idx = 0;
                tmp = " ";
            } else  {
                idx++;
                tmp = idx % 2 == 0
                        ? (String.valueOf(s.charAt(i)).toUpperCase(Locale.ROOT))
                        : (String.valueOf(s.charAt(i)).toLowerCase(Locale.ROOT));
            }

            sb.append(tmp);
        }

        return sb.toString();

//        String[] arr = s.split("\\s+");
//
//        StringBuilder sb;
//        StringBuilder answer = new StringBuilder();
//        for(int i = 0; i < arr.length; i++)   {
//            String str = arr[i];
//            sb = new StringBuilder();
//            for(int j = 0; j < str.length(); j++)   {
//                if(j % 2 == 0)  {
//                    sb.append(str.charAt(j));
//                } else  {
//                    sb.append(str.charAt(j));
//                }
//            }
//            answer.append(sb.toString());
//            if(i != arr.length - 1) {
//                answer.append(" ");
//            }
//        }
//
//        return answer.toString();
    }
}
