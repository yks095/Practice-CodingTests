package programmers.kakao;

import java.util.*;

/**
 * 방금그곡
 * https://programmers.co.kr/learn/courses/30/lessons/17683
 */
public class TheSong {
    public static void main(String[] args) {
//        String m = "ABCDEFG";
//        String[] musicinfos = {
//                "12:00,12:14,HELLO,CDEFGAB",
//                "13:00,13:05,WORLD,ABCDEF"
//        };

        String m = "CC#BCC#BCC#BCC#B";
        String[] musicinfos = {
                "03:00,03:30,FOO,CC#B",
                "04:00,04:08,BAR,CC#BCC#BCC#B"
        };
//
//        String m = "ABC";
//        String[] musicinfos = {
//                "12:00,12:14,HELLO,C#DEFGAB",
//                "13:00,13:05,WORLD,ABCDEF"
//        };

//        String m = "CCD";
//        String[] musicinfos = {
//                "03:00,03:10,FOO,CCD#CCD",
//                "04:00,04:08,BAR,ABC"
//        };

        System.out.println(solution(m, musicinfos));
    }

    static List<MusicInfo> musicInfoList;
    static String[] originScore = {"A#", "C#", "D#", "F#", "G#"};
    static String[] convertScore = {"a", "c", "d", "f", "g"};


    private static String solution(String m, String[] musicinfos) {
        initData(musicinfos);

        List<MusicInfo> guessMusic = findMusic(m);

        return pickMusic(guessMusic);
    }

    private static String pickMusic(List<MusicInfo> guessMusic) {
        if(guessMusic.size() == 0)  {
            return "(None)";
        } else if(guessMusic.size() == 1)   {
            return guessMusic.get(0).name;
        }

        Collections.sort(guessMusic);

        return guessMusic.get(0).name;
    }

    private static List<MusicInfo> findMusic(String m) {
        List<MusicInfo> foundMusic = new ArrayList<>();

        for(int i = 0; i < originScore.length; i++) {
            if(m.contains(originScore[i]))   {
                m = m.replaceAll(originScore[i], convertScore[i]);
            }
        }

        for (MusicInfo musicInfo : musicInfoList) {
            int time = musicInfo.playTime;
            String tempScore = musicInfo.score;
            String score = "";

            if(tempScore.length() > time)   {
                score = tempScore.substring(0, time);
            } else  {
                while(time-- != 0)  {
                    score = score.concat(tempScore);
                }
            }

            if(score.contains(m))   {
                foundMusic.add(musicInfo);
            }
        }

        return foundMusic;
    }

    private static void initData(String[] musicinfos) {
        musicInfoList = new ArrayList<>();

        for (int i = 0; i < musicinfos.length; i++) {
            String[] music = musicinfos[i].split(",");

            String startTime = music[0];
            String endTime = music[1];
            String name = music[2];
            String score = music[3];
            int playTime = calculateMusicPlayTime(startTime, endTime);

            for(int j = 0; j < originScore.length; j++) {
                if(score.contains(originScore[j]))   {
                    score = score.replaceAll(originScore[j], convertScore[j]);
                }
            }

            musicInfoList.add(new MusicInfo(i + 1, startTime, music[1], playTime, name, score));
        }
    }

    private static int calculateMusicPlayTime(String startTime, String endTime) {
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");

        int startMinute = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int endMinute = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);

        return endMinute - startMinute;
    }

    static class MusicInfo implements Comparable<MusicInfo>  {
        int id;
        String startTime;
        String endTime;
        int playTime;
        String name;
        String score;

        public MusicInfo(int id, String startTime, String endTime, int playTime, String name, String score) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
            this.playTime = playTime;
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "MusicInfo{" +
                    "id=" + id +
                    ", startTime='" + startTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", playTime=" + playTime +
                    ", name='" + name + '\'' +
                    ", score='" + score + '\'' +
                    '}';
        }

        @Override
        public int compareTo(MusicInfo m) {
            if(playTime != m.playTime)   {
                return m.playTime - playTime;
            } else  {
                return id - m.id;
            }
        }
    }
}
