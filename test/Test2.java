package test;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        String[] before = {"A", "B", "C", "D"};
        String[] after = {"B", "Z", "D", "C"};

        System.out.println(solution(before, after));
    }

    private static int solution(String[] before, String[] after) {
        int result = 0;
        int visitedCount = 0;
        boolean[] isVisited = new boolean[before.length];
        List<String> beforeList = Arrays.asList(before);
        List<String> afterList = Arrays.asList(after);
        Set<String> ballSet = new HashSet<>();

        System.out.println(beforeList);
        System.out.println(afterList);

        for(int i = 0; i < before.length; i++)  {
            String beforeAlphabet = beforeList.get(i);
            String afterAlphabet = afterList.get(i);

            if(beforeAlphabet.equals(afterAlphabet))    {
                // 동일한 위치의 동일한 문자
                isVisited[i] = true;
            } else if(afterList.contains(beforeAlphabet))   {
                // 다른 위치의 포함하는 문자
                ballSet.add(beforeAlphabet);
            }

            if(!isVisited[i] && !beforeList.contains(afterAlphabet)) {
                // 새로운 문자
                result++;
                isVisited[i] = true;
                visitedCount++;
            }
        }

        if(ballSet.size() == beforeList.size()) {
            return ballSet.size() + 1;
        }

        if(ballSet.isEmpty())   {
            return visitedCount;
        }

        System.out.println("result : " + result + ", ball size : " + ballSet.size());


        return ballSet.size() == 1 ? result + 1 : result + (ballSet.size() + 1);
    }
}
