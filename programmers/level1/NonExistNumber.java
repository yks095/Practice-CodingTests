package programmers.level1;

/**
 * 없는 숫자 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/86051?language=java
 */
public class NonExistNumber {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int answer = 0;
        int[] cnt = new int[10];

        for(int i = 0; i < numbers.length; i++) {
            cnt[numbers[i]]++;
        }

        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] == 0) {
                answer += i;
            }
        }


        return answer;
    }
}
