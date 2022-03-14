package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 가운데를 말해요
 * https://www.acmicpc.net/problem/1655
 */
public class Q1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; i++)  {
            int number = Integer.parseInt(br.readLine());
            if(minPQ.size() == maxPQ.size())    {
                maxPQ.add(number);
            } else  {
                minPQ.add(number);
            }

            if(!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
                maxPQ.add(minPQ.poll());
                minPQ.add(maxPQ.poll());
            }

            sb.append(maxPQ.peek()).append("\n");
        }

        System.out.println(sb);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        List<Integer> result = new ArrayList<>();
//
//        int count = Integer.parseInt(br.readLine());
//        while(count-- != 0) {
//            pq.add(Integer.parseInt(br.readLine()));
//            result.add(getMiddleNumber(pq));
//        }
//
//        for (Integer i : result) {
//            System.out.println(i);
//        }
//
//    }
//
//    private static int getMiddleNumber(PriorityQueue<Integer> pq) {
//        List<Integer> tmp = new ArrayList<>();
//        int result;
//        int size = pq.size();
//
//        if(size == 1 || size == 2)   {
//            result =  pq.peek();
//        } else  {
//            int div = (size / 2);
//            if(size % 2 == 0)   {
//                div -= 1;
//            }
//
//            while (div-- != 0)  {
//                tmp.add(pq.poll());
//            }
//
//            result = pq.peek();
//            pq.addAll(tmp);
//        }
//
//        return result;
//    }
}
