package programmers.level1;

import java.util.Arrays;
import java.util.List;

public class DayOfTheWeek {

    public final static List<String> day = Arrays.asList("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");
    public final static List<Integer> month = Arrays.asList(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    public static String solution(int a, int b) {
        int days = b + 5;
        for(int i = 0; i < a - 1; i++)    {
            days += month.get(i);
        }

        System.out.println(days);

        while(days > 7)  {
            days -= 7;
        }

        return day.get(days - 1);
    }
}
