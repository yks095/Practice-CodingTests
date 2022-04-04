package programmers.kakao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 후보키
 * https://programmers.co.kr/learn/courses/30/lessons/42890?language=java
 */
public class CandidateKey {
    public static void main(String[] args) {
        String[][] relation = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        };

        System.out.println(solution(relation));
    }

    private static int solution(String[][] relation) {
        int answer = 0;
        int[] columns = new int[relation[0].length];
        boolean[] isVisited;

        for(int i = 0; i < columns.length; i++) {
            columns[i] = i;
        }

        for(int i = 0; i < columns.length; i++) {
            isVisited = new boolean[columns.length];

            // TODO N개의 컬럼 중 (i + 1)개의 예비 후보키 생성
            List<String> keys = combination(columns, isVisited,  i + 1, i);

            // TODO 예비 후보키 조합으로 유일성 확인 -> Map의 key로 넣었을 때, 행의 갯수와 Map의 key의 갯수가 같은지


            // TODO 최소성 확인
        }

        return answer;
    }

    private static List<String> combination(int[] columns, boolean[] isVisited, int count, int idx) {
        if(count == 0)  {
            for(int k = 0; k < columns.length; k++) {
                if(isVisited[k])    {
                    System.out.print(columns[k] + " ");
                }
            }

            return new ArrayList<>();
        } else  {
            for(int k = count; k < columns.length; k++) {
                isVisited[k] = true;
                combination(columns, isVisited, count - 1, idx + 1);
                isVisited[k] = false;
            }
        }

        return new ArrayList<>();
    }
}
