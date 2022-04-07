package programmers.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * [3차] 파일명 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/17686
 */
public class SortFileName {
    public static void main(String[] args) {
        // "img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"
//        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        // "A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"
        String[] files = {"F-5 Freedom Fighter", "B-50", "A-10 Thunderbolt II", "F-14 Tomcat"};

        String[] result = solution(files);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }

    private static String[] solution(String[] files) {
        List<Filename> filenameList = new ArrayList<>();

        for(int i = 0; i < files.length; i++)   {
            String head, number, tail;
            int j = 0, h = 0, n = 0, t = 0;
            boolean isFirst = true;

            String file = files[i];
            while(j < file.length()) {
                if(isNumber(file.charAt(j)) && isFirst)  {
                    n = j;
                    isFirst = false;
                }
                if(n != 0 && !isNumber(file.charAt(j)))  {
                    t = j;
                    break;
                }

                j++;
            }

            head = file.substring(h, n);
            if(t != 0)  {
                number = file.substring(n, t);
                tail = file.substring(t);
            } else  {
                number = file.substring(n);
                tail = "";
            }

            filenameList.add(new Filename(i + 1, file, head, number, tail));
        }

        Collections.sort(filenameList);

        return convertListToArray(filenameList);
    }

    private static String[] convertListToArray(List<Filename> filenameList) {
        String[] result = new String[filenameList.size()];
        for(int i = 0; i < filenameList.size(); i++)    {
            result[i] = filenameList.get(i).originalName;
        }
        return result;
    }

    private static boolean isNumber(char c) {
        try {
            Integer.parseInt(String.valueOf(c));

            return true;
        } catch (NumberFormatException e)   {
            return false;
        }
    }

    static class Filename implements Comparable<Filename>{
        int id;
        String originalName;
        String head;
        String number;
        String tail;

        public Filename(int id, String originalName, String head, String number, String tail) {
            this.id = id;
            this.originalName = originalName;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(Filename f) {
            if(!head.toLowerCase(Locale.ROOT).equals(f.head.toLowerCase(Locale.ROOT)))   {
                return head.toLowerCase(Locale.ROOT).compareTo(f.head.toLowerCase(Locale.ROOT));
            }
            if(Long.parseLong(number) != Long.parseLong(f.number))  {
                return (int) (Long.parseLong(number) - Long.parseLong(f.number));
            }

            return id - f.id;
        }
    }
}
