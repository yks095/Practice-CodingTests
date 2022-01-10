package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 오픈채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */
public class OpenChattingRoom {
    public static void main(String[] args) {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        String[] answer = solution(record);

        for (String s : answer) {
            System.out.println(s);
        }
    }

    private static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (String s : record) {
            String[] arr = s.split("\\s+");
            if(!"Leave".equals(arr[0]))  {
                map.put(arr[1], arr[2]);
            }
        }

        for (String s : record) {
            String[] arr = s.split("\\s+");
            if ("Enter".equals(arr[0])) {
                list.add(map.get(arr[1]) + "님이 들어왔습니다.");
            } else if ("Leave".equals(arr[0])) {
                list.add(map.get(arr[1]) + "님이 나갔습니다.");
            }
        }

        return list.toArray(new String[0]);
    }
}
