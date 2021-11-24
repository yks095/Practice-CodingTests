package programmers.level1;

import java.util.Arrays;
import java.util.List;

/**
 * 키패드 누르기
 * https://programmers.co.kr/learn/courses/30/lessons/67256?language=java
 */
public class PressKeypad {
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        System.out.println(solution(numbers, hand));    // LRLLLRLLRRL
    }

    private static String solution(int[] numbers, String hand) {
        List<String> leftLine = Arrays.asList("1", "4", "7", "*");
        List<String> middleLine = Arrays.asList("2", "5", "8", "0");
        List<String> rightLine = Arrays.asList("3", "6", "9", "#");

        int leftIdx = 3;
        int rightIdx = 3;
        int leftToMiddle = 1;
        int rightToMiddle = 1;

        StringBuilder sb = new StringBuilder();

        for (int number : numbers) {
            String keypad = String.valueOf(number);

            if (leftLine.contains(keypad)) {
                leftIdx = leftLine.indexOf(keypad);
                sb.append("L");
                leftToMiddle = 1;
            } else if (rightLine.contains(keypad)) {
                rightIdx = rightLine.indexOf(keypad);
                sb.append("R");
                rightToMiddle = 1;
            } else {
                int middleIdx = middleLine.indexOf(keypad);
                int leftDistance = Math.abs(leftIdx - middleIdx) + leftToMiddle;
                int rightDistance = Math.abs(rightIdx - middleIdx) + rightToMiddle;

                if(leftDistance < rightDistance)    {
                    leftIdx = middleLine.indexOf(keypad);
                    sb.append("L");
                    leftToMiddle = 0;
                } else if(rightDistance < leftDistance) {
                    rightIdx = middleLine.indexOf(keypad);
                    sb.append("R");
                    rightToMiddle = 0;
                } else  {
                    if("left".equals(hand)) {
                        leftIdx = middleLine.indexOf(keypad);
                        sb.append("L");
                        leftToMiddle = 0;
                    } else  {
                        rightIdx = middleLine.indexOf(keypad);
                        sb.append("R");
                        rightToMiddle = 0;
                    }
                }
            }
        }

        return sb.toString();
    }
}
