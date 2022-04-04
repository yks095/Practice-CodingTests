package programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    private static int[] solution(String[] info, String[] query) {
        List<ApplierInfo> appliers = initInfo(info);
        ArrayList<String>[] queries = initQuery(query);

//        printArrayList(applier);
//        printArrayList(queries);

        return queryApplier(appliers, queries);
    }

    private static void printArrayList(ArrayList<String>[] array) {
        for (ArrayList<String> list : array) {
            System.out.println();
            for (String s : list) {
                System.out.println(s + " ");
            }
        }
    }

    private static List<ApplierInfo> initInfo(String[] info) {
        List<ApplierInfo> appliers = new ArrayList<>();

        for(int i = 0; i < info.length; i++)    {
            appliers.add(new ApplierInfo(info[i].split("\\s+")));
        }

        Collections.sort(appliers);

        return appliers;
    }

    private static ArrayList<String>[] initQuery(String[] query) {
        ArrayList<String>[] queries = new ArrayList[query.length];

        for(int i = 0; i < queries.length; i++) {
            queries[i] = new ArrayList<>(Arrays.asList(query[i].trim().split("\\sand\\s+|\\s+")));
        }

        return queries;
    }

    private static int[] queryApplier(List<ApplierInfo> appliers, ArrayList<String>[] queries) {
        int[] result = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
            ArrayList<String> query = queries[i];
            int basisScore = Integer.parseInt(query.get(4));

            System.out.println("score : " + basisScore);

            result[i] = countAdjustApplier(basisScore, appliers, query);
        }

        return result;
    }

    private static int countAdjustApplier(int basisScore, List<ApplierInfo> appliers, ArrayList<String> query) {
        int left = 0, mid = 0, right = appliers.size();
        int count = 0;

        while(left <= right)    {
            mid = (left + right) / 2;
            if(appliers.get(mid).score < basisScore)   {
                left = mid + 1;
            } else  {
                right = mid - 1;
            }
        }

        List<ApplierInfo> extractedAppliers = appliers.subList(mid, appliers.size() - 1);

        for(int i = mid; i < extractedAppliers.size(); i++)   {
            ApplierInfo applierInfo = extractedAppliers.get(i);
            System.out.println(applierInfo);
            System.out.println(query);
            if(isAdjustApplier(applierInfo, query)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isAdjustApplier(ApplierInfo applierInfo, ArrayList<String> query) {
        boolean isAdjust = true;

        if(isNotHyphen(query.get(0)) && isNotEmpty(query.get(0)))   {
            if (!query.get(0).equals(applierInfo.language))    {
                isAdjust = false;
            }
        }

        if(isNotHyphen(query.get(1)) && isNotEmpty(query.get(1)))   {
            if(!query.get(1).equals(applierInfo.position)) {
                isAdjust = false;
            }
        }

        if(isNotHyphen(query.get(2)) && isNotEmpty(query.get(2)))   {
            if(!query.get(2).equals(applierInfo.career)) {
                isAdjust = false;
            }
        }

        if(isNotHyphen(query.get(3)) && isNotEmpty(query.get(3)))   {
            if(!query.get(3).equals(applierInfo.soulFood)) {
                isAdjust = false;
            }
        }

        return isAdjust;
    }

    private static boolean isNotEmpty(String query) {
        return !query.isEmpty();
    }

    private static boolean isNotHyphen(String query) {
        return !"-".equals(query);
    }

    static class ApplierInfo implements Comparable<ApplierInfo>    {
        String language;
        String position;
        String career;
        String soulFood;
        int score;

        public ApplierInfo(String[] info) {
            this.language = info[0];
            this.position = info[1];
            this.career = info[2];
            this.soulFood = info[3];
            this.score = Integer.parseInt(info[4]);
        }

        @Override
        public int compareTo(ApplierInfo o) {
            return score - o.score;
        }

        @Override
        public String toString() {
            return "ApplierInfo{" +
                    "language='" + language + '\'' +
                    ", position='" + position + '\'' +
                    ", career='" + career + '\'' +
                    ", soulFood='" + soulFood + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
