package programmers.kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 주차 요금 계산
 * https://programmers.co.kr/learn/courses/30/lessons/92341?language=java
 */
public class ParkingFee {
    public static void main(String[] args) {
//        int[] fees = {180, 5000, 10, 600};
//        String[] records = {
//                "05:34 5961 IN",
//                "06:00 0000 IN",
//                "06:34 0000 OUT",
//                "07:59 5961 OUT",
//                "07:59 0148 IN",
//                "18:59 0000 IN",
//                "19:09 0148 OUT",
//                "22:59 5961 IN",
//                "23:00 5961 OUT"
//        };  // 14600, 34400, 5000

//        int[] fees = {120, 0, 60, 591};
//        String[] records = {
//                "16:00 3961 IN",
//                "16:00 0202 IN",
//                "18:00 3961 OUT",
//                "18:00 0202 OUT",
//                "23:58 3961 IN"
//        };  // 0, 591
//
        int[] fees = {1, 461, 1, 10};
        String[] records = {
                "00:00 1234 IN"
        };  // 14841

        int[] result = solution(fees, records);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = calculateCarNumberPerTime(records);

        return calculateCarNumberPerFee(fees, map);
    }

    private static int[] calculateCarNumberPerFee(int[] fees, Map<String, Integer> map) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        for (String key : map.keySet()) {
            int value = map.get(key);
            if(value <= basicTime)   {
                map.put(key, basicFee);
            } else  {
                map.put(key, basicFee + calculateAdditionalFee(value - basicTime, unitTime, unitFee));
            }
        }

        String[] keys = map.keySet().toArray(new String[0]);
        int[] answer = new int[keys.length];
        Arrays.sort(keys);

        for(int i = 0; i < answer.length; i++)  {
            answer[i] = map.get(keys[i]);
        }
        return answer;
    }

    private static int calculateAdditionalFee(int value, int unitTime, int unitFee) {
        if(value % unitTime != 0)   {
            return (value / unitTime + 1) * unitFee;
        }

        return (value / unitTime) * unitFee;
    }

    private static Map<String, Integer> calculateCarNumberPerTime(String[] records) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();

        for (String record : records) {
            String[] info = record.split("\\s+");
            String time = info[0];
            String carNumber = info[1];
            String to = info[2];

            if(map.containsKey(carNumber) && "OUT".equals(to))    {
                String prevTime = map.get(carNumber);
                int minute = calculateTimeToMinute(prevTime, time);
                map.put(carNumber, "0");
                result.put(carNumber, result.get(carNumber) == null ? minute : result.get(carNumber) + minute);
            } else  {
                if("IN".equals(to))    {
                    map.put(carNumber, time);
                }
            }
        }



        for (String key : map.keySet()) {
            String value = map.get(key);
            if(!value.equals("0"))  {
                int additionalTime = calculateTimeToMinute(value, "23:59");
                result.put(key, result.get(key) == null ? additionalTime : result.get(key) + additionalTime);
            }
        }

        return result;
    }

    private static int calculateTimeToMinute(String prevTime, String time) {
        String[] curTimeArr = time.split(":");
        String[] prevTimeArr = prevTime.split(":");

        int curMinute = Integer.parseInt(curTimeArr[0]) * 60 + Integer.parseInt(curTimeArr[1]);
        int prevMinute = Integer.parseInt(prevTimeArr[0]) * 60 + Integer.parseInt(prevTimeArr[1]);

        return curMinute - prevMinute;
    }
}
