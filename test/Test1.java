package test;

public class Test1 {
    public static void main(String[] args) {
        int money = 4;
        int limit = 4;

        int[] result = solution(money, limit);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] solution(int money, int limit) {
        int[] result = new int[2];

        if(money >= limit)  {
            return new int[]{1, 0};
        }

        int count = 2;

        while(limit != 1 && count != 0)    {
            if(money < limit)   {
                result[1]++;
                count = 2;
//                if(limit == 1)  {
//                    break;
//                }
                limit /= 2;
            } else  {
                result[0]++;
                count--;
//                if(count == 0)  {
//                    break;
//                }
                money -= limit;
            }
        }

        return result;
    }
}
