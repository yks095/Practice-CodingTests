package programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 순위 검색
 * https://programmers.co.kr/learn/courses/30/lessons/72412?language=java
 */
public class RankingSearch {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        int[] result = solution(info, query);   // [1,1,1,1,2,4]

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(String[] info, String[] query) {
        ArrayList<String>[] applier = initInfo(info);
        ArrayList<String>[] queries = initQuery(query);

        printArrayList(applier);
        printArrayList(applier);

        return queryApplier(applier, queries);
    }

    private static void printArrayList(ArrayList<String>[] array) {
        for (ArrayList<String> list : array) {
            System.out.println();
            for (String s : list) {
                System.out.println(s + " ");
            }
        }
    }

    private static ArrayList<String>[] initInfo(String[] info) {
        ArrayList<String>[] applier = new ArrayList[info.length];

        for(int i = 0; i < info.length; i++)    {
            applier[i] = (ArrayList<String>) Arrays.asList(info[i].split("\\s+"));
        }

        return applier;
    }

    private static ArrayList<String>[] initQuery(String[] query) {
        ArrayList<String>[] queries = new ArrayList[query.length];

        for(int i = 0; i < queries.length; i++) {
            queries[i] = (ArrayList<String>) Arrays.asList(query[i].trim().split("and"));
        }

        return queries;
    }

    private static int[] queryApplier(ArrayList<String>[] applier, ArrayList<String>[] queries) {
        int[] result = new int[queries.length];

        return result;
    }
}
