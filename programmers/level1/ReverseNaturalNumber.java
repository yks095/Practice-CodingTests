package programmers.level1;

/**
 * 자연수 뒤집어 배열로 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12932?language=java
 */
public class ReverseNaturalNumber {
    public static void main(String[] args) {
        long n = 12345;
        solution(n);
    }

    private static int[] solution(long n) {
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(arr.length - 1 - i);
            arr[i] = c - 48;
        }

        return arr;
    }
}
