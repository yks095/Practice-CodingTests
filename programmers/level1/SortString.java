package programmers.level1;

import java.util.*;

/**
 * 문자열 내 마음대로 정렬하기
 * https://programmers.co.kr/learn/courses/30/lessons/12915?language=java
 */
public class SortString {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        String[] solution = solution(strings, n);

        for(String s : solution)    {
            System.out.print(s + " ");
        }
    }

    private static String[] solution(String[] strings, int n) {
        List<String> list = new ArrayList<>();
        String[] arr = new String[strings.length];

        for (String string : strings) {
            list.add(string.charAt(n) + string);
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++)    {
            arr[i] = list.get(i).substring(1);
        }

        return arr;
    }
}
