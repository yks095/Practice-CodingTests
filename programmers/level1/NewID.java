package programmers.level1;

/**
 * 신규 아이디 추천
 * https://programmers.co.kr/learn/courses/30/lessons/72410?language=java
 */
public class NewID {
    public static void main(String[] args) {
        String newId = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution(newId));
    }

    public static String solution(String newId) {
        newId = step1(newId);
        System.out.println("step 1 : " + newId);

        newId = step2(newId);
        System.out.println("step 2 : " + newId);

        newId = step3(newId);
        System.out.println("step 3 : " + newId);

        newId = step4(newId);
        System.out.println("step 4 : " + newId);

        newId = step5(newId);
        System.out.println("step 5 : " + newId);

        newId = step6(newId);
        System.out.println("step 6 : " + newId);

        newId = step7(newId);
        System.out.println("step 7 : " + newId);

        return newId;
    }

    // 1단계 : new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    private static String step1(String newId) {
        return newId.toLowerCase();
    }

    // 2단계 : new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    private static String step2(String newId) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < newId.length(); i++)   {
            char c = newId.charAt(i);

            if((c >= 97 && c <= 122) || (c >= 48 && c <= 57) || c == '-' || c == '_' || c == '.')    {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    // 3단계 : new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    private static String step3(String newId)   {
        return newId.replaceAll("\\.{2,}", ".");
    }

    // 4단계 : new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    private static String step4(String newId) {
        if(newId.startsWith("."))   {
            newId = newId.substring(1);
        }

        if(newId.endsWith(".")) {
            newId = newId.substring(0, newId.length() - 1);
        }

        return newId;
    }

    // 5단계 : new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    private static String step5(String newId)   {
        if(null == newId || newId.isEmpty())    {
            newId = "a";
        }

        return newId;
    }

    // 6단계 : new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다. 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    private static String step6(String newId) {
        if(newId.length() >= 16)    {
            newId = newId.substring(0, 15);
            if(newId.endsWith(".")) {
                newId = newId.substring(0, newId.length() - 1);
            }
        }

        return newId;
    }

    // 7단계 : new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    private static String step7(String newId) {
        if(newId.length() <= 2) {
            char c = newId.charAt(newId.length() - 1);
            while(newId.length() != 3)  {
                newId += c;
            }
        }

        return newId;
    }


}
