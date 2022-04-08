package programmers.kakao;

/**
 * 문자열 압축
 * https://programmers.co.kr/learn/courses/30/lessons/60057?language=java
 */
public class CompressString {
    public static void main(String[] args) {
//        String s = "aabbaccc";
        String s = "ababcdcdababcdcd";
//        String s = "abcabcdede";
//        String s = "abcabcabcabcdededededede";
//        String s = "xababcdcdababcdcd";

        System.out.println(solution(s));
    }

    private static int solution(String s) {
        if(s.length() == 1) {
            return 1;
        }
        int minLength = Integer.MAX_VALUE;

        for(int i = 1; i < s.length() / 2 + 1; i++) {
            int compressedLength = compression(s, i);
            minLength = Math.min(minLength, compressedLength);
        }

        return minLength;
    }

    private static int compression(String s, int i) {
        int count = 1;
        String prevPattern = "";
        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < s.length() + i; j += i)  {
            String curPattern = subString(s, i, j);

            if(j != 0)  {
                if(curPattern.equals(prevPattern))  {
                    count++;
                } else  {
                    if(count >= 2)  {
                        sb.append(count);
                        count = 1;
                    }
                    sb.append(prevPattern);
                }
            }
            prevPattern = curPattern;
        }

        return sb.length();
    }

    private static String subString(String s, int i, int j) {
        String curPattern;

        if(j >= s.length())  {
            curPattern = "";
        } else if(j + i > s.length()) {
            curPattern = s.substring(j);
        } else  {
            curPattern = s.substring(j, j + i);
        }

        return curPattern;
    }
}
