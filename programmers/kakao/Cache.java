package programmers.kakao;

import java.util.LinkedList;
import java.util.Locale;

/**
 * 캐시
 * https://programmers.co.kr/learn/courses/30/lessons/17680
 */
public class Cache {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(solution(cacheSize, cities));
    }

    private static int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0)  {
            return 5 * cities.length;
        }

        int time = 0;
        LinkedList<String> list = new LinkedList<>();

        for (String s : cities) {
            String city = s.toLowerCase(Locale.ROOT);
            time = LRU(cacheSize, time, list, city);
        }

        return time;
    }

    private static int LRU(int cacheSize, int time, LinkedList<String> list, String city) {
        if(list.contains(city))    {
            list.remove(city);
            list.addLast(city);
            time += 1;
        } else  {
            if(list.size() == cacheSize)    {
                list.removeFirst();
            }

            list.addLast(city);
            time += 5;
        }
        return time;
    }
}
