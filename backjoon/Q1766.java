//package backjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
///**
// * 문제집
// * https://www.acmicpc.net/problem/1766
// */
//public class Q1766 {
//
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static PriorityQueue<Integer> queue;
//    static List<List<Integer>> graph;
//
//
//    public static void main(String[] args) throws IOException {
//        graph = new ArrayList<>();
//        queue = new PriorityQueue<>();
//
//        String firstLine = br.readLine();
//        int N = Integer.parseInt(firstLine.split("\\s+")[0]);
//        int M = Integer.parseInt(firstLine.split("\\s+")[1]);
//
//        for(int i = 0; i <= N; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for(int i = 1; i <= M; i++)  {
//            String order = br.readLine();
//            int prev = Integer.parseInt(order.split("\\s+")[0]);
//            int next = Integer.parseInt(order.split("\\s+")[1]);
//
//            graph.get(prev - 1).add(next);
//        }
//
//        for(int i = 0; i < graph.size(); i++)   {
//            if(graph.get(i).isEmpty())  {
//                queue.add(i + 1);
//            }
//        }
//
//
//
//        System.out.println(graph);
//
//
//
//
//
//
//
//    }
//
//    static class Question {
//        int number;
//        int nextQuestionNumber;
//
//        public Question(int number, int nextQuestionNumber) {
//            this.number = number;
//            this.nextQuestionNumber = nextQuestionNumber;
//        }
//
//        public int getNumber() {
//            return number;
//        }
//
//        public Integer getNextQuestionNumber() {
//            return nextQuestionNumber;
//        }
//
//        public void setNextQuestionNumber(int nextQuestionNumber) {
//            this.nextQuestionNumber = nextQuestionNumber;
//        }
//    }
//}
