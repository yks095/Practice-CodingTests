package programmers.level1;

/**
 * 정수 내림차순으로 배치하기
 * https://programmers.co.kr/learn/courses/30/lessons/12933?language=java
 */
public class DescNumber {
    public static void main(String[] args) {
        long n = 12543;
        System.out.println(solution(n));
    }

    private static long solution(long n) {
        String s = String.valueOf(n);
        char[] arr = new char[s.length()];

        for(int i = 0; i < s.length(); i++)    {
            arr[i] = s.charAt(i);
        }

        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] < arr[j + 1]) {
                    char tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char j : arr) {
            sb.append(j);
        }

        return Long.parseLong(sb.toString());
    }
}
