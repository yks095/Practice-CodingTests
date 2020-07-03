package backjoon;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 3, 3, 4, 3, 4};
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            map.get(map.containsKey(arr[i]) ? map.put(arr[i], map.get(arr[i]) + 1) : map.put(arr[i], 1));
        }

        for(int i : map.keySet())   {
            if(map.get(i) > 1)  {
                System.out.println(map.get(i));
            }
        }



    }
}
