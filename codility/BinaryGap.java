package codility;
import java.util.*;

public class BinaryGap {
}

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        List<Integer> list = new ArrayList<>();
        int i = 0;

        while(N != 1)   {
            list.add(N % 2);
            i++;
            N /= 2;
        }

        list.add(N);
        int cnt = 0;
        int idx = i;
        int max = 0;

        for(int j = i; j >= 0; j--) {
            if(list.get(j) == 1)    {
                if(cnt % 2 == 0)    {
                    if(cnt != 1 && max <= idx - j - 1)    {
                        max = idx - j - 1;
                    }
                    idx = j;
                    cnt++;
                }
                else    {
                    if(max <= idx - j - 1)
                        max = idx - j - 1;
                    idx = j;
                    cnt++;
                }
            }
        }

        return max;
    }
}
