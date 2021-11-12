package programmers.level1;

/**
 * 문자열 내림차순으로 배치하기
 * https://programmers.co.kr/learn/courses/30/lessons/12917?language=java
 */
public class AscString {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        char[] arr = s.toCharArray();

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

        return sb.toString();
    }
}
