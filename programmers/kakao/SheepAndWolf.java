//package programmers.kakao;
//
//import java.util.ArrayList;
//
///**
// * 양과 늑대
// * https://programmers.co.kr/learn/courses/30/lessons/92343
// */
//public class SheepAndWolf {
//    public static void main(String[] args) {
//        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
//        int[][] edges = {{0,1}, {1,2}, {1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
//
//        System.out.println(solution(info, edges));
//    }
//
//    static int curSheep = 0, curWolf = 0;
//    static int totalSheep = 0, totalWolf = 0;
//    static ArrayList<Integer>[] tree;
//
//    private static int solution(int[] info, int[][] edges) {
//        initTree(info, edges);
//
//        dfs(0, info);
//
//    }
//
//    private static void dfs(int i, int[] info) {
//        for(int n : tree[i])    {
//            if(info[n] == 0)    {
//                curSheep++;
//            } else  {
//
//            }
//        }
//    }
//
//    private static void initTree(int[] info, int[][] edges) {
//        tree = new ArrayList[info.length];
//        for(int i = 0; i < tree.length; i++)    {
//            tree[i] = new ArrayList<>();
//
//            if(info[i] == 0)    {
//                totalSheep++;
//            } else  {
//                totalWolf++;
//            }
//        }
//
//        for(int i = 0; i < edges.length; i++)   {
//            tree[edges[i][0]].add(edges[i][1]);
//            tree[edges[i][1]].add(edges[i][0]);
//        }
//    }
//
//    static class Node   {
//        Node parent;
//        String species;
//        Node left;
//        Node right;
//
//        public Node(Node parent, String species, Node left, Node right) {
//            this.parent = parent;
//            this.species = species;
//            this.left = left;
//            this.right = right;
//        }
//    }
//}
