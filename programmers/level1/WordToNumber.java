package programmers.level1;

import java.util.Arrays;
import java.util.List;

/**
 * 숫자 문자열과 영단어
 * https://programmers.co.kr/learn/courses/30/lessons/81301?language=java
 */
public class WordToNumber {
    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        List<String> list = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        for(int i = 0; i < list.size(); i++)  {
            s = s.replaceAll(list.get(i), String.valueOf(i));
        }

        return Integer.parseInt(s);
    }
}
