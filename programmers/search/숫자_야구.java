package programmers.search;

import java.util.ArrayList;
import java.util.List;

public class 숫자_야구 {
    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1},
                {356, 1, 0},
                {327, 2, 0},
                {489, 0, 1}};

        System.out.println(solution(baseball));
    }

    private static int solution(int[][] baseball) {
        List<String> list = new ArrayList<>();

        for(int i = 0; i < 1000; i++)   {
            if(!String.valueOf(i).contains("0"))    {
                if(String.valueOf(i).length() == 3) {
                    list.add(String.valueOf(i));
                }
            }
        }

        List<String> list2 = new ArrayList<>(list);
        String[] number;

        for (int[] ints : baseball) {
            number = String.valueOf(ints[0]).split("");

            for (String s : list) {
                int strike = getStrike(number, s);
                int ball = getBall(number, s);

                if ((strike != ints[1]) || (ball != ints[2])) {
                    list2.remove(s);
                }
            }
        }

        return list2.size();
    }

    private static int getStrike(String[] number, String num) {
        int strike = 0;
        for(int i = 0; i < number.length; i++)  {
            if(num.charAt(i) == number[i].charAt(0)) {
                strike++;
            }
        }
        return strike;
    }

    private static int getBall(String[] number, String num) {
        int ball = 0;
        for(int i = 0; i < number.length; i++)  {
            if((num.charAt(i) != number[i].charAt(0)) && num.contains(number[i])) {
                ball++;
            }
        }
        return ball;
    }
}
