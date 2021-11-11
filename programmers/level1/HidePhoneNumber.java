package programmers.level1;

/**
 * 핸드폰 번호 가리기
 * https://programmers.co.kr/learn/courses/30/lessons/12948
 */
public class HidePhoneNumber {
    public static void main(String[] args) {
        String phone_number = "01012345678";
        System.out.println(solution(phone_number));

    }

    private static String solution(String phone_number) {
        String substring = phone_number.substring(phone_number.length() - 4);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < phone_number.length() - 4; i++)  {
            sb.append("*");
        }

        return sb.append(substring).toString();
    }
}
