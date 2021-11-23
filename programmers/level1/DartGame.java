package programmers.level1;

/**
 * 다트 게임
 * https://programmers.co.kr/learn/courses/30/lessons/17682?language=java
 */
public class DartGame {
    public static void main(String[] args) {
        /*
        1S2D*3T     -> 37
        1D2S#10S	-> 9
        1D2S0T	    -> 3
        1S*2T*3S	-> 23 (24)
        1D#2S*3S	-> 5  (8)
        1T2D3D#	    -> -4
        1D2S3T*	    -> 59
         */

        String dartResult = "1D2S3T*";

        System.out.println(solution(dartResult));
    }

    private static int solution(String dartResult) {
        int totalScore = 0;
        int curScore = 0;
        int prevScore = 0;

        String[] number = dartResult.split("\\D+");
        String[] calculate = dartResult.split("[0-9]+");

        for(int i = 0; i < number.length; i++) {
            int num = Integer.parseInt(number[i]);
            String cal = calculate[i + 1];

            for(int j = 0; j < cal.length(); j++)    {
                String s = String.valueOf(cal.charAt(j));

                switch(s)   {
                    case "S":
                        curScore = num;
                        break;
                    case "D":
                        curScore = (int) Math.pow(num, 2);
                        break;
                    case "T":
                        curScore = (int) Math.pow(num, 3);
                        break;
                    case "*":
                        curScore *= 2;
                        totalScore += prevScore;
                        break;
                    case "#":
                        curScore *= -1;
                        break;
                    default:
                        break;
                }
            }

            totalScore += curScore;
            prevScore = curScore;
        }

        return totalScore;
    }


}
