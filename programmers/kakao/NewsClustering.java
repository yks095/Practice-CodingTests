package programmers.kakao;

import java.util.*;
import java.util.regex.Pattern;

/**
 * [1차] 뉴스 클러스터링
 * https://programmers.co.kr/learn/courses/30/lessons/17677
 */
public class NewsClustering {
    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";

        System.out.println(solution(str1, str2));
    }

    static String regex = "^[a-zA-Z]*$";

    private static int solution(String str1, String str2) {
        List<String> listA = initList(str1);
        List<String> listB = initList(str2);

        printList(listA);
        System.out.println();
        printList(listB);

        if(listA.size() == 0 && listB.size() == 0)  {
            return 65536;
        }

        return (int) (jaccardSimilarity(listA, listB) * 65536);
    }

    private static double jaccardSimilarity(List<String> listA, List<String> listB) {
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        for(String s : listA)   {
            if(listB.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        union.addAll(listB);

        return (double) intersection.size() / union.size();
    }

    private static List<String> initList(String str) {
        List<String> list = new ArrayList<>();
        StringBuilder sb;

        for(int i = 0; i < str.length() - 1; i++)   {
            sb = new StringBuilder();
            sb.append(String.valueOf(str.charAt(i)).toLowerCase(Locale.ROOT))
                    .append(String.valueOf(str.charAt(i + 1)).toLowerCase(Locale.ROOT));

            if(!Pattern.matches(regex, sb.toString()))   {
                continue;
            }

            list.add(sb.toString());
        }

        return list;
    }

    private static void printList(List<String> list)    {
        for(int i = 0; i < list.size(); i++)    {
            System.out.println(list.get(i));
        }
    }
}
