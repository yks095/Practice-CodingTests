package programmers.level1;

/**
 * 음양 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/76501?language=java
 */
public class PlusMinus {
    public static void main(String[] args) {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true, false, true};

        System.out.println(solution(absolutes, signs));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < signs.length; i++)   {
            if(!signs[i])  {
                absolutes[i] *= -1;
            }
        }

        for(int i : absolutes)  {
            answer += i;
        }

        return answer;
    }
}
