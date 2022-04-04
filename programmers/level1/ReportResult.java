package programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 신고 결과 받기
 * https://programmers.co.kr/learn/courses/30/lessons/92334?language=java
 */
public class ReportResult {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};  // {"con", "ryan"}, {"muzi", "frodo", "apeach", "neo"}
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}; // {"ryan con", "ryan con", "ryan con", "ryan con"}, {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}
        int k = 2; // 3, 2

        int[] result = solution(id_list, report, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, List<String>> reportMap = new HashMap<>();
        Map<String, List<String>> reportedMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        int[] result = new int[id_list.length];

        // 신고한 내용, 신고 받은 내용, 정지 메일 카운트 초기화
        for (String id : id_list) {
            reportMap.put(id, new ArrayList<>());
            reportedMap.put(id, new ArrayList<>());
            countMap.put(id, 0);
        }

        // 신고한 사용자, 신고 받은 사용자 저장
        for (String str : report) {
            String reporterId = str.split("\\s+")[0];
            String reportedId = str.split("\\s+")[1];

            reportMap.put(reporterId, addId(reportMap.get(reporterId), reportedId));
            reportedMap.put(reportedId, addId(reportedMap.get(reportedId), reporterId));
        }

        // k명 이상 신고 받을 시, 신고자 메일 대상 선정
        for (String key : reportedMap.keySet()) {
            List<String> values = reportedMap.get(key);
            if(values.size() >= k)    {
                for (String id : values) {
                    countMap.put(id, countMap.get(id) + 1);
                }
            }
        }

        for(int i = 0; i < id_list.length; i++)  {
            result[i] = countMap.get(id_list[i]);
        }

        return result;
    }

    private static List<String> addId(List<String> idList, String reportedId) {
        if(!idList.contains(reportedId)) {
            idList.add(reportedId);
        }

        return idList;
    }
}
