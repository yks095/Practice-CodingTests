package programmers.level1;

/**
 * 콜라츠 추측
 * https://programmers.co.kr/learn/courses/30/lessons/12943?language=java
 */
public class Collatz {
    public static void main(String[] args) {
        int num = 626331;
        System.out.println(solution(num));
    }

    public static int solution(int num) {
        long longNum = Long.parseLong(String.valueOf(num));
        return Math.toIntExact(recursiveCollatz(longNum, 0));
    }

    private static long recursiveCollatz(long num, int count) {
        if(count >= 501)    {
            return -1;
        }
        if(num == 1)    {
            return count;
        }

        if(num % 2 == 0)    {
            return recursiveCollatz(num / 2, ++count);
        } else  {
            return recursiveCollatz(num * 3 + 1, ++count);
        }
    }
}
