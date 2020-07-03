package programmers.hash;

import java.util.Arrays;

public class 전화번호_목록 {
    public static void main(String[] args) {
        String[] first = {"119", "97674223", "1195524421"};
        System.out.println(solution(first));
        String[] second = {"123", "456", "789"};
        System.out.println(solution(second));
        String[] third = {"12", "123", "1235", "567", "88"};
        System.out.println(solution(third));
    }

    private static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length; i++)   {
            for(int j = i + 1; j < phone_book.length; j++)   {
                if(phone_book[j].startsWith(phone_book[i]))   {
                    return false;
                }
            }
        }

        return true;
    }
}
