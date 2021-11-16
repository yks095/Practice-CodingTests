package programmers.level1;

/**
 * 약수의 개수와 덧셈
 * https://programmers.co.kr/learn/courses/30/lessons/77884?language=java
 */
public class CountDivisor {
    public static void main(String[] args) {
        int left = 24;
        int right = 27;
        System.out.println(solution(left, right));
    }

    private static int solution(int left, int right) {
        int sum = 0;

        for(int i = left; i <= right; i++)  {
            int count = 0;
            for(int j = 1; j <= Math.sqrt(i); j++)   {
                if(i % j == 0)  {
                    if(j == Math.sqrt(i))   {
                        count++;
                    } else  {
                        count += 2;
                    }
                }
            }

            if(count % 2 == 0)  {
                sum += i;
            } else  {
                sum -= i;
            }
        }

        return sum;
    }
}
