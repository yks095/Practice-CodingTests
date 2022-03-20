//package backjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.PriorityQueue;
//
///**
// * 회의실 배정
// * https://www.acmicpc.net/problem/1931
// */
//public class Q1931 {
//
//    static PriorityQueue<Meeting> queue;
//    static List<Meeting> meetingList;
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void main(String[] args) throws IOException {
//        meetingList = new ArrayList<>();
//        queue = new PriorityQueue<>(
//                ((Meeting m1, Meeting m2) -> m1.getTerm() > m2.getTerm() ? 1 : -1)
//        );
//
//        int N = Integer.parseInt(br.readLine());
//
//        for(int i = 0; i < N; i++)  {
//            String time = br.readLine();
//            int start = Integer.parseInt(time.split("\\s+")[0]);
//            int end = Integer.parseInt(time.split("\\s+")[1]);
//
//            queue.add(new Meeting(start, end));
//        }
//
//        while(!queue.isEmpty()) {
//            Meeting tempMeeting = queue.poll();
//
//            if(meetingList.isEmpty())   {
//                meetingList.add(tempMeeting);
//            } else  {
//                boolean isJoinable = true;
//                for (Meeting reservedMeeting : meetingList) {
//                    if (isDuplicatedTime(tempMeeting, reservedMeeting)) {
//                        isJoinable = false;
//                        break;
//                    }
//                }
//
//                if(isJoinable)  {
//                    meetingList.add(tempMeeting);
//                }
//            }
//        }
//
//        System.out.println(meetingList.size());
//    }
//
//    private static boolean isDuplicatedTime(Meeting tempMeeting, Meeting reservedMeeting) {
//        return (tempMeeting.getEnd() >= reservedMeeting.getStart() && tempMeeting.getEnd() <= reservedMeeting.getEnd())
//                || (tempMeeting.getStart() <= reservedMeeting.getEnd() && tempMeeting.getStart() >= reservedMeeting.getEnd());
//    }
//
//    static class Meeting    {
//        int start;
//        int end;
//        int term;
//
//        public Meeting(int start, int end) {
//            this.start = start;
//            this.end = end;
//            this.term = end - start;
//        }
//
//        public int getStart() {
//            return start;
//        }
//
//        public int getEnd() {
//            return end;
//        }
//
//        public int getTerm() {
//            return term;
//        }
//    }
//}
