package programmers.kakao;

/**
 * 124나라
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 */
public class Nation124 {
    public static void main(String[] args) {
//        int n = 1;  // 1
//        int n = 2;  // 2
//        int n = 3;  // 4
//        int n = 4;  // 11
        int n = 9;

        for(int i = 1; i <= 10; i++)    {
            System.out.println(solution(i));
        }

    }

    private static String solution(int n) {
        String number = ternaryScale(n);

        return number.replaceAll("3", "4");
    }

    private static String ternaryScale(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0)    {
            if(n % 3 == 0)  {
                sb.append("3");
                n = (n / 3) - 1;
            } else  {
                sb.append(n % 3);
                n /= 3;
            }
        }
        return sb.reverse().toString();
    }
}
