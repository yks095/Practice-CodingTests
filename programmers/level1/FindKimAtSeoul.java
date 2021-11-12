package programmers.level1;

/**
 * 서울에서 김서방 찾기
 * https://programmers.co.kr/learn/courses/30/lessons/12919?language=java
 */
public class FindKimAtSeoul {
    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        System.out.println(solution(seoul));
    }

    private static String solution(String[] seoul) {
        int idx = 0;

        for(int i = 0; i < seoul.length; i++)   {
            if("Kim".equals(seoul[i]))   {
                idx = i;
                break;
            }
        }

        return "김서방은 " + idx + "에 있다";
    }
}
