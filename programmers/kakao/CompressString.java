package programmers.kakao;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

/**
 * 문자열 압축
 * https://programmers.co.kr/learn/courses/30/lessons/60057?language=java
 */
public class CompressString {
    public static void main(String[] args) {
        String s = "aabbaccc";
//        String s = "ababcdcdababcdcd";
//        String s = "abcabcdede";
//        String s = "abcabcabcabcdededededede";
//        String s = "xababcdcdababcdcd";

        System.out.println(solution(s));
    }

    static Map<String, Integer> dictionary;
    static int[] count;

    private static int solution(String s) {
        count = new int[s.length() / 2 + 1];
        dictionary = new HashMap<>();


        calculateCompressedString(s);

        return 1;
    }

    private static void calculateCompressedString(String s) {
        int length = s.length();
        int curLength = length / 2;

        while (curLength != 0)  {
            System.out.println("curLength : " + curLength + "\n");
            for(int i = 0; i < length; i += curLength) {
                String sub;
                if(length - i < curLength)  {
                    sub = s.substring(i, length);
                } else  {
                    sub = s.substring(i, i + curLength);
                }

                dictionary.put(sub, dictionary.get(sub) == null ? 1 : dictionary.get(sub) + 1);
            }

            for (String key : dictionary.keySet()) {
                System.out.print(key + " ");
            }
            System.out.println();

            curLength--;
        }

    }
}
