package programmers.kakao;

import java.util.*;

/**
 * 메뉴 리뉴얼
 * https://programmers.co.kr/learn/courses/30/lessons/72411?language=java
 */
public class MenuRenewal {
    public static void main(String[] args) {
//        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] course = {2,3,4};

        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2,3,5};
//
//        String[] orders = {"XYZ", "XWY", "WXA"};
//        int[] course = {2,3,4};

        String[] result = solution(orders, course);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }

    private static String[] solution(String[] orders, int[] course) {
        List<Map<String, Integer>> list = initData();

        combinationMenus(orders, course, list);

        return selectCourseMenus(course, list);
    }

    private static String[] selectCourseMenus(int[] course, List<Map<String, Integer>> list) {
        List<String> resultList = new ArrayList<>();
        List<String> maxKeys;
        for (int j : course) {
            maxKeys = new ArrayList<>();
            int maxCount = Integer.MIN_VALUE;
            Map<String, Integer> map = list.get(j);
            for (String key : map.keySet()) {
                int value = map.get(key);

                if (value >= 2) {
                    if (value > maxCount) {
                        maxKeys.clear();
                        maxKeys.add(key);
                        maxCount = value;
                    } else if (value == maxCount) {
                        maxKeys.add(key);
                    }
                }
            }

            resultList.addAll(maxKeys);
        }

        Collections.sort(resultList);

        String[] result = new String[resultList.size()];
        for(int i = 0; i < resultList.size(); i++)  {
            result[i] = resultList.get(i);
        }

        return result;
    }

    private static void combinationMenus(String[] orders, int[] course, List<Map<String, Integer>> list) {
        boolean[] isVisited;
        for (String s : orders) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String order = new String(a);

            for (int i : course) {
                isVisited = new boolean[order.length()];

                Map<String, Integer> map = list.get(i);
                combination(map, order, isVisited, 0, i);
            }
        }

        for (Map<String, Integer> map : list) {
            for (String s : map.keySet()) {
                System.out.println("key : " + s + ", value : " + map.get(s));
            }
        }
    }

    private static List<Map<String, Integer>> initData() {
        List<Map<String, Integer>> list = new ArrayList<>();
        for(int i = 0; i < 11; i++) {
            list.add(new HashMap<>());
        }

        return list;
    }

    private static void combination(Map<String, Integer> map, String order, boolean[] isVisited, int start, int length) {
        if(length == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < isVisited.length; i++)   {
                if(isVisited[i])    {
                    sb.append(order.charAt(i));
                }
            }

            String menu = sb.toString();
            map.put(menu, map.get(menu) == null ? 1 : map.get(menu) + 1);

        } else  {
            for(int i = start; i < order.length(); i++) {
                isVisited[i] = true;
                combination(map, order, isVisited, i + 1, length - 1);
                isVisited[i] = false;
            }
        }
    }
}
