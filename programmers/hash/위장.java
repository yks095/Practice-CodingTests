package programmers.hash;

import java.util.*;

public class 위장 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"},
                              {"blue_sunglasses", "eyewear"},
                              {"green_turban", "headgear"}};

        System.out.println(solution(clothes));      // 5

        clothes = new String[][]{{"crow_mask", "face"},
                                 {"blue_sunglasses", "face"},
                                 {"smoky_makeup", "face"}};
        System.out.println(solution(clothes));      // 3
    }

    private static int solution(String[][] clothes) {
        int species = 1;
        Map<String, Set<String>> map = new HashMap<>();
        for(String[] cloth : clothes) {
            String key = cloth[1];
            String value = cloth[0];

            if(map.containsKey(key))    {
                Set<String> set = map.get(key);
                set.add(value);
                map.put(key, set);
            }
            else    {
                Set<String> set = new HashSet<>();
                set.add(value);
                map.put(key, set);
            }
        }

        for(String key : map.keySet()) {
            species *= (map.get(key).size() + 1);
        }

        return species - 1;
    }
}
