package programmers.kakao;

import java.util.*;

/**
 * 튜플
 * https://programmers.co.kr/learn/courses/30/lessons/64065?language=java
 */
public class Tuple {
    public static void main(String[] args) {
//        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";     // 2, 1, 3, 4
//        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";     // 2, 1, 3, 4
//        String s = "{{20,111},{111}}";                  // 111, 20
//        String s = "{{123}}";                           // 123
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";     // 3, 2, 4, 1

        int[] result = solution(s);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(String s) {
        Map<String, Integer> map = extractInteger(s);
        List<Map.Entry<String, Integer>> entryList = sortMapByValueDesc(map);

        int[] result = new int[map.size()];
        int idx = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            result[idx++] = Integer.parseInt(entry.getKey());
        }

        return result;
    }

    private static List<Map.Entry<String, Integer>> sortMapByValueDesc(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        return entryList;
    }

    private static Map<String, Integer> extractInteger(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] split = s.split("[{,}]");
        for (String str : split) {
            if("".equals(str))  {
                continue;
            }

            map.put(str, map.get(str) == null ? 1 : map.get(str) + 1);
        }
        return map;
    }
}
