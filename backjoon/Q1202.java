package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 보석 도둑
 * https://www.acmicpc.net/problem/1202
 */
public class Q1202 {

    static PriorityQueue<Jewel> jewelQueue;
    static PriorityQueue<Integer> bagQueue;
    static PriorityQueue<Integer> jewelValueQueue;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long result = 0L;
        jewelQueue = new PriorityQueue<>(((Jewel j1, Jewel j2) -> {
            if(j1.getWeight() == j2.getWeight())  {
                return j2.getValue() - j1.getValue();
            }

            return j1.getWeight() - j2.getWeight();
        }));
        bagQueue = new PriorityQueue<>();
        jewelValueQueue = new PriorityQueue<>(Comparator.reverseOrder());

        String firstLine = br.readLine();
        int N = Integer.parseInt(firstLine.split("\\s+")[0]);
        int K = Integer.parseInt(firstLine.split("\\s+")[1]);

        for(int i = 1; i <= N; i++)  {
            String jewel = br.readLine();
            int weight = Integer.parseInt(jewel.split("\\s+")[0]);
            int value = Integer.parseInt(jewel.split("\\s+")[1]);

            jewelQueue.add(new Jewel(weight, value));
        }

        for(int i = 0; i < K; i++) {
            bagQueue.add(Integer.parseInt(br.readLine()));
        }

        for(int i = 0; i < K; i++)    {
            Integer bag = bagQueue.poll();
            while(!jewelQueue.isEmpty() && jewelQueue.peek().getWeight() <= bag)    {
                jewelValueQueue.add(jewelQueue.poll().getValue());
            }

            if(!jewelValueQueue.isEmpty())  {
                result += jewelValueQueue.poll();
            }
        }

        System.out.println(result);
    }

    static class Jewel  {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public int getValue() {
            return value;
        }
    }
}
