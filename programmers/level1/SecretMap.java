package programmers.level1;

/**
 * 비밀 지도
 * https://programmers.co.kr/learn/courses/30/lessons/17681?language=java
 */
public class SecretMap {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] answer = solution(n, arr1, arr2);

        for(String s : answer)  {
            System.out.println("\"" + s + "\"");
        }

    }

    private static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] s1 = convertToBinary(n, arr1);
        String[] s2 = convertToBinary(n, arr2);
        String[] answer = new String[n];

        for(int i = 0; i < n; i++)  {
            answer[i] = solveBinary(s1[i], s2[i]);
        }

        return answer;
    }

    private static String[] convertToBinary(int n, int[] arr) {
        String[] s = new String[arr.length];
        StringBuilder sb;

        for(int i = 0; i < arr.length; i++)    {
            sb = new StringBuilder();
            int num = arr[i];
            while(num > 0)    {
                int rest = num % 2;
                sb.insert(0, rest);
                num /= 2;
            }

            if(sb.toString().length() != n) {
                while(sb.toString().length() < n)    {
                    sb.insert(0, "0");
                }
            }

            s[i] = sb.toString();
        }

        return s;
    }

    private static String solveBinary(String s1, String s2) {
        StringBuilder sb = new StringBuilder();

        System.out.println(s1 + " " + s2);

        for(int i = 0; i < s1.length(); i++)    {
            String s = ( Integer.parseInt(String.valueOf(s1.charAt(i))) | Integer.parseInt(String.valueOf(s2.charAt(i))) ) == 0 ? " " : "#";
            sb.append(s);
        }

        System.out.println(sb.toString() + "\n");

        return sb.toString();
    }
}
