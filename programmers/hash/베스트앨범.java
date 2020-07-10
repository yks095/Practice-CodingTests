package programmers.hash;

import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};


        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    private static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> play = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            play.put(i, plays[i]);
            if (!hashMap.containsKey(genres[i])) {
                hashMap.put(genres[i], plays[i]);
            } else {
                hashMap.put(genres[i], hashMap.get(genres[i]) + plays[i]);
            }
        }

        TreeMap<String, Integer> album = new TreeMap<>(hashMap);
        List<String> list = new ArrayList<>(album.keySet());
        List<Integer> answer = new ArrayList<>();
        list.sort((o1, o2) -> (album.get(o2).compareTo(album.get(o1))));

        for (String key : list) {
            System.out.println("key : " + key);
            int[] arr = new int[genres.length];
            int j = 0;

            for (int i = 0; i < genres.length; i++) {
                if (key.equals(genres[i])) {
                    arr[j++] = plays[i];
                }
            }

            Arrays.sort(arr);
            int k = 4;

            if(arr[arr.length - 2] == 0)    {
                for (Integer i : play.keySet()) {
                    if (play.get(i).equals(arr[k])) {
                        answer.add(i);
                        k--;
                    }
                }
            }
            else    {
                for (Integer i : play.keySet()) {
                    if (play.get(i).equals(arr[k])) {
                        answer.add(i);
                        k--;
                    }
                }

                for (Integer i : play.keySet()) {
                    if (play.get(i).equals(arr[k])) {
                        answer.add(i);
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
            System.out.println("answer : " + answer);

        }

        int[] result = new int[answer.size()];

        for(int i = 0; i < result.length; i++)  {
            result[i] = answer.get(i);
        }

        return result;
    }
}
