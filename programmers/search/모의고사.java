package programmers.search;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {
    public static void main(String[] args)  {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));    // [1]
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));    // [1, 2, 3]
    }

    public static int[] solution(int[] answers)    {

        long start = System.nanoTime();

        int[] results = new int[3];
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int max = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == first[i % first.length]) {
                results[0]++;
            }
            if(answers[i] == second[i % second.length]) {
                results[1]++;
            }
            if(answers[i] == third[i % third.length]) {
                results[2]++;
            }
        }

        for(int i = 0; i < results.length; i++) {
            if(max <= results[i])
                max = results[i];
        }

        for(int i = 0; i < results.length; i++) {
            if(max == results[i])
                arrayList.add(i);
        }

        int[] answer = new int[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++)   {
            answer[i] = arrayList.get(i) + 1;
        }

        System.out.println(System.nanoTime() - start);

        return answer;

    }
}
