package programmers.level1;

/**
 * 수박수박수박수박수박수?
 * https://programmers.co.kr/learn/courses/30/lessons/12922?language=java
 */
public class WatermelonClap {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

    private static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < (n / 2); i++)    {
            sb.append("수박");
        }

        return n % 2 == 1 ? sb.append("수").toString() : sb.toString();
    }
}
