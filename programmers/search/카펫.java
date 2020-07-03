package programmers.search;

import java.util.Arrays;

public class 카펫 {
    public static void main(String[] args) {
        int[] brown = {10, 8, 24, 14, 18, 24, 11};
        int[] yellow = {2, 1, 24, 4, 6, 1, 1};

        for(int i = 0; i < brown.length; i++)   {
            System.out.println(Arrays.toString(solution(brown[i], yellow[i])));
        }
    }

    private static int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int width = 0, height = 0;
        int[] answer = new int[2];

        for(int i = 3; i <= sum; i++)   {
            if(sum % i == 0)    {
                width = sum / i;
                height = i;

                int a = width - 2;
                int b = height - 2;

                if(a * b == yellow && width >= height)  {
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }

        return answer;
    }
}
