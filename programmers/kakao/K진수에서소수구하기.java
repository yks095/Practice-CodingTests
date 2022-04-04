package programmers.kakao;

/**
 * K진수에서 소수 구하기
 * https://programmers.co.kr/learn/courses/30/lessons/92335?language=java
 */
public class K진수에서소수구하기 {
    public static void main(String[] args) {
        int n = 1000000;                         // 437674, 110011
        int k = 10;                            // 3, 10

        System.out.println(solution(n, k));     // 3, 2
    }

    private static int solution(int n, int k) {
        String digit = convertNumberToKDigit(n, k);

        return countPrimeNumber(digit);
    }

    private static int countPrimeNumber(String digit) {
        int count = 0;

        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < digit.length(); i++) {
            char c = digit.charAt(i);
            String str = temp.toString();

            if(c == '0' && !str.isEmpty())    {
                if(isPrimeNumber(Long.parseLong(str)))   {
                    count++;
                }
                temp = new StringBuilder();
            } else  {
                temp.append(c);
            }
        }

        if(!temp.toString().isEmpty() && isPrimeNumber(Long.parseLong(temp.toString())))   {
            count++;
        }

        return count;
    }

    private static boolean isPrimeNumber(long number) {
        if(number <= 1) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(number); i++)  {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // 10진수 -> k진수로 변환
    private static String convertNumberToKDigit(int n, int k) {
        return Integer.toString(n, k);
//        if(k == 10) {
//            return String.valueOf(n);
//        }
//
//
//        StringBuilder sb = new StringBuilder();
//        while(n != 0)   {
//            sb.append(n % k);
//            n /= k;
//        }
//        sb.reverse();
//
//        return sb.toString();
    }
}
