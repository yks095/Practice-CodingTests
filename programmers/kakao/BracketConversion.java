package programmers.kakao;

import java.util.Stack;

/**
 * 괄호 변환
 * https://programmers.co.kr/learn/courses/30/lessons/60058?language=java
 */
public class BracketConversion {
    public static void main(String[] args) {
//        String p = "(()())()";  // (()())()
//        String p = ")(";        // ()
        String p = "()))((()";  // ()(())()

        System.out.println(solution(p));
    }

    private static String solution(String p) {
        return convertBracket(p);
    }

    private static String convertBracket(String p) {
        if(p.isEmpty()) {
            return "";
        } else  {
            String[] arr = separateBalancedBracket(p);
            String u = arr[0];
            String v = arr[1];

            if(isProperBracket(u)) {
                return u.concat(convertBracket(v));
            }

            StringBuilder sb = new StringBuilder();
            sb.append("(").append(convertBracket(v)).append(")");

            for(int i = 1; i < u.length() - 1; i++) {
                if(u.charAt(i) == '(')  {
                    sb.append(")");
                } else  {
                    sb.append("(");
                }
            }

            return sb.toString();
        }
    }

    private static String[] separateBalancedBracket(String p) {
        int leftCount = 0;
        int rightCount = 0;

        for(int i = 0; i < p.length(); i++) {
            char bracket = p.charAt(i);
            if(bracket == '(')  {
                leftCount++;
            } else  {
                rightCount++;
            }

            if(leftCount != 0 && rightCount != 0)   {
                if(leftCount == rightCount) {
                    break;
                }
            }
        }
        int idx = leftCount + rightCount;
        String u = p.substring(0, idx);
        String v = idx == p.length() ? "" : p.substring(idx);

        return new String[]{u, v};
    }

    private static boolean isBalancedBracket(String str) {
        int leftCount = 0;
        int rightCount = 0;

        for(int i = 0; i < str.length(); i++) {
            char bracket = str.charAt(i);
            if(bracket == '(')  {
                leftCount++;
            } else  {
                rightCount++;
            }
        }

        return leftCount == rightCount;
    }

    private static boolean isProperBracket(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++)   {
            char bracket = str.charAt(i);
            if(bracket == '(')  {
                stack.push(bracket);
            } else if(!stack.isEmpty() && stack.peek() == '(')  {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
