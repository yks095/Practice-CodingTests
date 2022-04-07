package programmers.kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * N진수 게임
 * https://programmers.co.kr/learn/courses/30/lessons/17687
 */
public class NDigitGame {
    public static void main(String[] args) {
//        int n = 2;
//        int t = 4;
//        int m = 2;
//        int p = 1;

        int n = 16;
        int t = 16;
        int m = 2;
        int p = 1;

//        int n = 16;
//        int t = 16;
//        int m = 2;
//        int p = 2;


        System.out.println(solution(n, t, m, p));   // 0111
    }

    private static String solution(int n, int t, int m, int p) {
        // TODO t * m 의 최댓값 만큼의 n진수를 구함
        List<String> numbers = calculateDigit(n, t, m);

        printArray(numbers);

        // TODO t개만큼 튜브의 숫자를 찾을 때 까지 반복
        return concatNumbers(t, m, p, numbers);
    }

    private static void printArray(List<String> numbers) {
        for(int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }

    private static String concatNumbers(int t, int m, int p, List<String> numbers) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(sb.length() < t) {
            String str = numbers.get(i + p - 1);
            sb.append(str);
            i += m;
        }
        return sb.toString();
    }

    private static List<String> calculateDigit(int n, int t, int m) {
        List<String> numbers = new ArrayList<>();
        int limit = t * m;

        for(int i = 0; i <= limit; i++) {
            String number = convertToDigit(i, n);
            for(int j = 0; j < number.length(); j++)    {
                numbers.add(String.valueOf(number.charAt(j)));
            }
        }

        return numbers;
    }

    private static String convertToDigit(int i, int n) {
        return Integer.toString(i, n).toUpperCase(Locale.ROOT);
    }
}
