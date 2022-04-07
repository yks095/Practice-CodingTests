package programmers.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 압축
 * https://programmers.co.kr/learn/courses/30/lessons/17684
 */
public class Compression {
    public static void main(String[] args) {
//        String msg = "KAKAO";                       // 11, 1, 27, 15
        String msg = "TOBEORNOTTOBEORTOBEORNOT";    // 20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34
//        String msg = "ABABABABABABABAB";            // 1, 2, 27, 29, 28, 31, 30

        int[] result = solution(msg);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static Map<String, Integer> alphabet;
    private static int[] solution(String msg) {
        alphabet = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 65; i < 91; i++) {
            addAlphabet(String.valueOf((char) i), i - 64);
        }

        int idx;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < msg.length(); i++)   {
            sb.append(msg.charAt(i));
            idx = alphabet.get(sb.toString()) == null ? -1 : alphabet.get(sb.toString());

            // 다음 문자열을 붙힐 수 있으면 붙히고 넘어가기
            if (availableConcat(msg, sb, i)) {
                continue;
            }

            result.add(idx);
            addAlphabet(sb.toString(), alphabet.size() + 1);
            sb = new StringBuilder();
        }

        return convertListToArray(result);
    }

    private static void addAlphabet(String str, int idx) {
        alphabet.put(String.valueOf(str), idx);
    }

    private static boolean availableConcat(String msg, StringBuilder sb, int i) {
        if(i + 1 < msg.length())  {
            String c = String.valueOf(msg.charAt(i + 1));
            if(alphabet.containsKey(sb + c)) {
                return true;
            }
            sb.append(c);
        }
        return false;
    }

    private static int[] convertListToArray(List<Integer> result) {
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
