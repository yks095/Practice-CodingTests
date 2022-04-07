package programmers.kakao;

import java.util.*;

/**
 * 순위 검색
 * https://programmers.co.kr/learn/courses/30/lessons/72412?language=java
 */
public class RankingSearch {

    public static void main(String[] args) {
        String[] info = {"" +
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String[] query = {"" +
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        int[] result = solution(info, query);   // [1,1,1,1,2,4]

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static Map<String, ArrayList<Integer>> map;
    static String[] splitInfo;
    static int score;
    static String[] temp;

    private static int[] solution(String[] info, String[] query) {
        initData(info);

        sortScores();

        return queryApplier(query);
    }

    private static int[] queryApplier(String[] query) {
        int[] result = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] split = query[i].split(" and | ");

            for(int j = 0; j < split.length - 1; j++)   {
                sb.append(split[j]);
            }

            if(map.containsKey(sb.toString())) {
                result[i] = findOverScoreApplier(map.get(sb.toString()), Integer.parseInt(split[4]));
            }
        }

        return result;
    }

    private static int findOverScoreApplier(ArrayList<Integer> list, int score) {
        int left = 0, right = list.size() - 1;

        while(left <= right)    {
            int mid = (left + right) / 2;
            if(list.get(mid) < score)   {
                left = mid + 1;
            } else  {
                right = mid - 1;
            }
        }

        return list.size() - left;
    }

    private static void sortScores() {
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
    }

    private static void initData(String[] info) {
        map = new HashMap<>();

        for (String i : info) {
            temp = new String[4];
            splitInfo = i.split("\\s+");
            score = Integer.parseInt(splitInfo[4]);

            dfs(0);
        }
    }

    private static void dfs(int i) {
        if(i == 4)  {
            StringBuilder sb = new StringBuilder();
            for (String s : temp) {
                sb.append(s);
            }

            if(!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<>());
            }
            map.get(sb.toString()).add(score);
        } else  {
            temp[i] = splitInfo[i];
            dfs(i + 1);
            temp[i] = "-";
            dfs(i + 1);
        }
    }
}
