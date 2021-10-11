package test.generic;

public class Test {
    public static void main(String[] args) {
        long solution = solution(3, 20, 4);
        System.out.println(solution);
    }

    public static long solution(int price, int money, int count) {
        while(count != 0) {
            money -= (count * price);
            System.out.println(money);
            count--;
        }

        if(money > 0)   {
            return 0;
        }

        return Math.abs(money);
    }
}
