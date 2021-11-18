//package programmers.level1;
//
//import java.util.*;
//
///**
// * 시저 암호
// * https://programmers.co.kr/learn/courses/30/lessons/12926?language=java
// */
//public class CaesarCipher {
//    public static void main(String[] args) {
//        String s = "Z";
//        int n = 1;
//        System.out.println(solution(s, n));
//    }
//
//    private static String solution(String s, int n) {
//        StringBuilder sb = new StringBuilder();
//
//        for(int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            String str = "";
//            if(c == ' ')    {
//                str = " ";
//            } else if((int)c >= 65 && (int)c <= 90) {
//                int num = (int)c + n;
//                int num2 = num % 65;
//
//                System.out.println("num = " + num + ", num2 = " + num2);
//
//                str = String.valueOf((char) (num - num2));
//            } else if((int)c >= 97 && (int)c <= 122)    {
//                int num = (int)c + n;
//                int num2 = num % 97;
//
//                System.out.println("num = " + num + ", num2 = " + num2);
//
//                str = String.valueOf((char) (num - num2));
//            }
//
//            sb.append(str);
//        }
//
//        return sb.toString();
//
//
//    }
//}
