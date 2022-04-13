package programmers.level2;

/**
 * 큰 수 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/42883?language=java
 */
public class MakeBigNumber {
    public static void main(String[] args) {
//        String number = "1924"; // 94
//        int k = 2;

        String number = "1231234";      // 3234
        int k = 3;
//
//        String number = "4177252841";   // 775841
//        int k = 4;

        System.out.println(solution(number, k));
    }
    private static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for(int i = 0; i < number.length() - k; i++)    {
            int max = 0;
            for(int j = idx; j <= i + k; j++)  {
                if(max < number.charAt(j) - '0') {
                   max = number.charAt(j) - '0';
                   idx = j + 1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
}
