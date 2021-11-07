package programmers.level1;

import java.util.Stack;

/**
 * 크레인 인형뽑기 게임
 * https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
 */
public class PickDoll {

    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println("총 터진 인형 갯수 : " + solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> result = new Stack<>();

        for(int i = 0; i < moves.length; i++)   {
            for(int j = 0; j < board.length; j++)   {
                int num = board[j][moves[i] - 1];
                if(num != 0)    {
                    if(result.peek().equals(num))   {
                        result.pop();
                        answer += 2;
                    } else  {
                        result.push(num);
                    }

                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
