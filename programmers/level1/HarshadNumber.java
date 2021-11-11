package programmers.level1;

/**
 * 하샤드 수
 * https://programmers.co.kr/learn/courses/30/lessons/12947
 */
public class HarshadNumber {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(solution(x));
    }

    private static boolean solution(int x) {
        String number = String.valueOf(x);
        int sum = 0;

        for (char c : number.toCharArray()) {
            sum += Integer.parseInt(String.valueOf(c));
        }

        return x % sum == 0;
    }
}
