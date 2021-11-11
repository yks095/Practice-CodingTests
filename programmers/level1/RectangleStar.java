package programmers.level1;

/**
 * 직사각형 별찍기
 * https://programmers.co.kr/learn/courses/30/lessons/12969
 */
public class RectangleStar {
    public static void main(String[] args) {
        String[] s = {"5", "3"};
        solution(s);
    }

    private static void solution(String[] s) {
        int width = Integer.parseInt(s[0]);
        int height = Integer.parseInt(s[1]);

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++)  {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
