package programmers.sort;

import java.util.Arrays;

public class K번째수 {

    public static void main(String[] args)  {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},
                            {4, 4, 1},
                            {1, 7, 3}};

        System.out.println(Arrays.toString(solution(array, commands))); // 5 6 3
    }

    private static int[] solution(int[] array, int[][] commands) {
        int[] results = new int[commands.length];

        long start = System.nanoTime();

//        Time : 183743nm
//        for(int i = 0; i < commands.length; i++)    {
//            int len = commands[i][1] - commands[i][0] + 1;
//            int[] arr = new int[len];
//            int idx = commands[i][0] - 1;
//
//            for(int j = 0; j < len; j++)    {
//                arr[j] = array[idx++];
//            }
//            Arrays.sort(arr);
//            results[i] = arr[commands[i][2] - 1];
//        }

//        Time : 171621
        for(int i = 0; i < commands.length; i++)    {
            int[] arr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(arr);
            results[i] = arr[commands[i][2] - 1];
        }

        long end = System.nanoTime();
        System.out.println("time : " + (end - start));

        return results;
    }
}
