package programmers.weekly;

/**
 * 2주차 상호평가
 * https://programmers.co.kr/learn/courses/30/lessons/83201?language=java
 */
public class SecondWeek {

    public static void main(String[] args) {
        int[][] scores = {
                {100,90,98,88,65},
                {50,45,99,85,77},
                {47,88,95,80,67},
                {61,57,100,80,65},
                {24,90,94,75,65}
        };

        String answer = solution(scores);
        System.out.println(answer);
    }


    public static String solution(int[][] scores) {
        String grade;
        StringBuilder answer = new StringBuilder();
        int[] sum = new int[scores.length];
        int[] div = new int[scores.length];

        for(int i = 0; i < scores.length; i++)    {
            int higher = 0, lower = 0, equal = 0;

            for(int j = 0; j < scores[i].length; j++) {
                // 자신이 매긴 점수보다 크거나 작거나 같은 갯수를 구함
                if(i != j)  {
                    if(scores[i][i] > scores[j][i])  {
                        higher++;
                    } else if(scores[i][i] < scores[j][i])  {
                        lower++;
                    } else  {
                        equal++;
                    }
                }

                sum[i] += scores[j][i];
            }

            // 자신이 매긴 점수가 중복이 안되고, 최고점이거나 최저점인지 확인
            if((higher == 0 || lower == 0) && (equal == 0))  {
                sum[i] -= scores[i][i];
                div[i] = scores.length - 1;
            } else  {
                div[i] = scores.length;
            }

            // 평균값 계산
            double avg = (double) sum[i] / div[i];

            // 평균값에 대한 등급 책정
            if(avg >= 90)    {
                grade = "A";
            } else if(avg >= 80 && avg < 90)  {
                grade = "B";
            } else if(avg >= 70 && avg < 80)  {
                grade = "C";
            } else if(avg >= 50 && avg < 70)  {
                grade = "D";
            } else {
                grade = "F";
            }

            answer.append(grade);
        }

        return answer.toString();
    }
}
