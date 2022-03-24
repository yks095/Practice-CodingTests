package programmers.test;

import java.util.*;

public class ReportResult {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

//        solution(id_list, report, k);    // [2, 1, 1, 0]
        int[] answer = solution(id_list, report, k);    // [2, 1, 1, 0]
        for (int i : answer) {
            System.out.print(i + " ");
        }

    }

    private static int[] solution(String[] id_list, String[] report, int k) {
        // 각자 신고한 사용자 리스트 추출
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (String s : report) {
            String[] arr = s.split("\\s+");
            String key = arr[0];
            String value = arr[1];

            if(map.containsKey(key))    {
                if(map.get(key).contains(value)) {
                    continue;
                }
                List<String> values = new ArrayList<>(map.get(key));
                values.add(value);
                map.put(key, values);
            } else  {
                map.put(key, Collections.singletonList(value));
            }

            count.put(value, count.containsKey(value) ? count.get(value) + 1 : 1);
        }


        // 신고된 사람 중, 자격 정지가 될 사용자 추출
        List<String> stopped = getStopped(count, k);


        // 신고자 중, 메일을 발송받아야 할 사용자 추출
        return getMailTo(id_list, map, stopped);
    }

    private static int[] getMailTo(String[] id_list, Map<String, List<String>> map, List<String> stopped) {
        int[] result = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];

            int count = 0;
            List<String> reported = map.get(id);
            for (String r : reported) {
                if(stopped.contains(r)) {
                    System.out.println("reporter : " + id + ", reported : " + map.get(id) + ", mail count : " + count);
                    count++;
                }
            }

            result[i] = count;
        }

        return result;
    }

    private static List<String> getStopped(Map<String, Integer> map, int k) {
        List<String> idList = new ArrayList<>();
        for (String id : map.keySet()) {
            if(map.get(id) >= k) {
                idList.add(id);
            }
        }

        return idList;
    }

//    private static Map<String, List<String>> getReportedMap (String[] report) {
//
//
//        return map;
//    }
}
