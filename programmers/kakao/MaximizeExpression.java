//package programmers.kakao;
//
//import java.util.*;
//
///**
// * 수식 최대화
// * https://programmers.co.kr/learn/courses/30/lessons/67257?language=java
// */
//public class MaximizeExpression {
//    public static void main(String[] args) {
//        String expression = "100-200*300-500+20";   // 60420
////        String expression = "50*6-3*2";             // 300
//
//        System.out.println(solution(expression));
//    }
//
//    static List<String> distinctOperations = new ArrayList<>();
//    static List<String> operationPerm = new ArrayList<>();
//    static boolean[] isVisited;
//
//    private static long solution(String expression) {
//        List<String> numbers = new ArrayList<>(Arrays.asList(expression.split("[+\\-*/]")));
//        List<String> operations = new ArrayList<>();
//        String[] splitOperation = expression.split("[0-9]+");
//
//        for (String s : splitOperation) {
//            if(!"".equals(s.trim()))    {
//                operations.add(s.trim());
//            }
//        }
//
////        printList(numbers);
////        printList(operations);
//
//        permutateOperations(operations);
//
//        return getMaxOperatedNumber(numbers, operations);
//    }
//
//    private static void printList(List<String> list) {
//        for (String s : list) {
//            System.out.print(s + " ");
//        }
//        System.out.println();
//    }
//
//    private static long getMaxOperatedNumber(List<String> numbers, List<String> operations) {
//        for(int i = 0; i < operationPerm.size(); i++)   {
//            String perm = operationPerm.get(i);
//            for(int j = 0; j < perm.length(); j++)  {
//                String p = String.valueOf(perm.charAt(j));
//                List<String> tempNumbers = new ArrayList<>(numbers);
//                List<String> tempOperations = new ArrayList<>(operations);
//
//                for(int k = 0; k < tempOperations.size(); k++)  {
//                    if(p.equals(tempOperations.get(k))) {
//                        long calculatedNumber = calculate(tempNumbers.get(k), tempNumbers.get(k + 1), p);
////                        System.out.println(numbers.get(k) + ", " + numbers.get(k + 1));
////                        System.out.println(calculatedNumber);
//                        tempNumbers.remove(tempNumbers.get(k + 1));
//                        tempNumbers.remove(tempNumbers.get(k));
//                        tempNumbers.add(k, String.valueOf(calculatedNumber));
//                        tempOperations.remove(p);
//                    }
//                }
//            }
//
//        }
//
//        return Long.parseLong(numbers.get(0));
//    }
//
//    private static long calculate(String number1, String number2, String p) {
//        long n1 = Long.parseLong(number1);
//        long n2 = Long.parseLong(number2);
//
//        switch (p)  {
//            case "+": return n1 + n2;
//            case "-": return n1 - n2;
//            case "*": return n1 * n2;
//            case "/": return n1 / n2;
//            default: return n1;
//        }
//    }
//
//    private static void permutateOperations(List<String> operations) {
//        for (String operation : operations) {
//            if(distinctOperations.contains(operation))  {
//                continue;
//            }
//            distinctOperations.add(operation);
//        }
//
//        int operationCount = distinctOperations.size();
//        isVisited = new boolean[operationCount];
//        permutation(new String[operationCount], 0, operationCount);
//
//        Collections.sort(operationPerm);
//
////        for (String s : operationPerm) {
////            System.out.print(s + " ");
////        }
//    }
//
//    private static void permutation(String[] arr, int depth, int operationCount) {
//        if(depth == operationCount) {
//            StringBuilder sb = new StringBuilder();
//            for (String s : arr) {
//                if("".equals(s.trim())) {
//                    continue;
//                }
//                sb.append(s);
//            }
//
//            if(!operationPerm.contains(sb.toString()))  {
//                operationPerm.add(sb.toString());
//            }
//        } else  {
//            for(int i = 0; i < distinctOperations.size(); i++)  {
//                if(!isVisited[i])   {
//                    isVisited[i] = true;
//                    arr[depth] = distinctOperations.get(i);
//                    permutation(arr, depth + 1, operationCount);
//                    isVisited[i] = false;
//                }
//            }
//        }
//    }
//
//
//}
