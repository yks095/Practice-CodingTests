//package programmers.level1;
//
///**
// *
// * 약수의 합
// * https://programmers.co.kr/learn/courses/30/lessons/12928?language=java
// */
//public class SumDivisor {
//    public static void main(String[] args) {
//        int n = 121;
//        System.out.println(solution(n));
//    }
//
//    private static int solution(int n) {
//        if(n == 0 || n == 1)  {
//            return n;
//        }
//
//        int sum = 0;
//        for(int i = 1; i <= Math.sqrt(n); i++)   {
//            if(n % i == 0)  {
//                System.out.println(i + ", " + n/i);
//                sum = sum + (i + n/i);
//            }
//        }
//
//        return sum;
//    }
//}
