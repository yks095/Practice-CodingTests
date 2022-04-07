package programmers.kakao;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

/**
 * 추석 트래픽
 * https://programmers.co.kr/learn/courses/30/lessons/17676
 */
public class ChoosukTraffic {
    public static void main(String[] args) {
//        String[] lines = {
//                "2016-09-15 01:00:04.002 2.0s",
//                "2016-09-15 01:00:07.000 2s"
//        };

        String[] lines = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };

        System.out.println(solution(lines));
    }

    static List<LogTimeInfo> timeList;

    private static int solution(String[] lines) {
        initLogData(lines);

        return maxProcessCount();
    }

    private static int maxProcessCount() {
        int maxProcessCount = Integer.MIN_VALUE;

        for(int i = 0; i < timeList.size(); i++)    {
            int processCount = 0;
            LogTimeInfo log = timeList.get(i);
            LocalDateTime startedAt = log.startedAt;
            LocalDateTime endedAt = log.endedAt;

            System.out.println("대상 : " + log);

            for(int j = 0; j < timeList.size(); j++)    {
//                if(i == j)  {
//                    continue;
//                }

                LogTimeInfo log2 = timeList.get(j);
                System.out.println("\n비교 : " + log2.toString());

                if((startedAt.isAfter(log2.startedAt)) || (startedAt.isEqual(log2.startedAt)))   {
                    System.out.print("this의 시작시간보다 (같거나)일찍 시작했고 ");
                    if(startedAt.minusSeconds(1).isBefore(log2.endedAt) || startedAt.minusSeconds(1).isEqual(log2.endedAt))   {
                        System.out.println("this의 시작시간보다 일찍 끝남");
                        processCount++;
                    } else if(startedAt.isBefore(log2.endedAt) && endedAt.isAfter(log2.endedAt))    {
                        System.out.println("this의 시작시간과 끝시간 사이에 끝남");
                        processCount++;
                    } else if(endedAt.plusSeconds(1).isBefore(log2.endedAt) || endedAt.plusSeconds(1).isEqual(log2.endedAt)) {
                        System.out.println("this의 끝시간 이후에 끝남");
                        processCount++;
                    }
                } else if((startedAt.isBefore(log2.startedAt) || startedAt.isEqual(log2.startedAt))
                        && (endedAt.isAfter(log2.startedAt) || endedAt.isEqual(log2.startedAt)))    {
                    System.out.println("this의 시작과 끝 사이에 시작했고 ");
                    if(startedAt.isBefore(log2.endedAt) && endedAt.isAfter(log2.endedAt))   {
                        System.out.println("this의 끝시간보다 일찍 끝남");
                        processCount++;
                    } else if(endedAt.plusSeconds(1).isBefore(log2.endedAt) || endedAt.plusSeconds(1).isEqual(log2.endedAt))   {
                        System.out.println("this의 끝 시간 이후에 끝남");
                        processCount++;
                    }
                } else if(endedAt.isBefore(log2.startedAt) || endedAt.isEqual(log2.startedAt)) {
                    System.out.println("this의 끝 시간 이후에 시작 함");
                    processCount++;
                }
            }

            System.out.println("processCount : " + processCount);
            System.out.println("maxCount : " + maxProcessCount);

            System.out.println("------------------------------------------------------------------------------------");

            /* 1. this의 시작시간 보다 (같거나)일찍 시작했고
                    - this의 시작시간보다 일찍 끝남
                    - this의 시작시간과 끝시간 사이에 끝남
                    - this의 끝시간 이후에 끝남

               2. this의 시작과 끝 사이에 시작했고
                    - this의 끝시간보다 일찍 끝남
                    - this의 끝 시간 이후에 끝남

               3. this의 끝 시간 이후에 시작 함

             */

            if(processCount > maxProcessCount)  {
                maxProcessCount  = processCount;
            }
        }

        return maxProcessCount;
    }

    private static void initLogData(String[] lines) {
        timeList = new ArrayList<>();
        for(int i = 0; i < lines.length; i++)   {
            String[] splitTime = lines[i].split("\\s+");

            LocalDateTime endedAt = convertStringToLocalDateTime(splitTime);
            int processTime = (int) (Double.parseDouble(splitTime[2].substring(0, splitTime[2].length() - 1)) * 1000);
            LocalDateTime startedAt = endedAt.minus(processTime - 1, ChronoField.MILLI_OF_DAY.getBaseUnit());

            LogTimeInfo e = new LogTimeInfo(i + 1, startedAt, endedAt, processTime);
//            System.out.println(e);
            timeList.add(e);
        }
    }

    private static LocalDateTime convertStringToLocalDateTime(String[] splitTime) {
        String[] ymd = splitTime[0].split("-");
        String[] hms = splitTime[1].split(":");
        String[] sec = hms[2].split("\\.");

        return LocalDateTime.of(
                Integer.parseInt(ymd[0]), Integer.parseInt(ymd[1]), Integer.parseInt(ymd[2]),   // yyyy-MM-dd
                Integer.parseInt(hms[0]), Integer.parseInt(hms[1]), Integer.parseInt(sec[0]))
                .plus(Integer.parseInt(sec[1]), ChronoField.MILLI_OF_DAY.getBaseUnit());  // HH:mm:ss.nn
    }

    static class LogTimeInfo implements Comparable<LogTimeInfo>    {
        int idx;
        LocalDateTime startedAt;
        LocalDateTime endedAt;
        int processTime;

        public LogTimeInfo(int idx, LocalDateTime startedAt, LocalDateTime endedAt, int processTime) {
            this.idx = idx;
            this.startedAt = startedAt;
            this.endedAt = endedAt;
            this.processTime = processTime;
        }

        @Override
        public String toString() {
            return "LogTimeInfo{" +
                    "startedAt=" + startedAt +
                    ", endedAt=" + endedAt +
                    ", processTime=" + processTime +
                    '}';
        }

        @Override
        public int compareTo(LogTimeInfo o) {
            if(!startedAt.equals(o.startedAt))  {
                return startedAt.compareTo(o.startedAt);
            }
            return o.endedAt.compareTo(endedAt);
        }
    }
}
