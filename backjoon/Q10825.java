package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 국영수
 * https://www.acmicpc.net/problem/10825
 */
public class Q10825 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static Student[] array;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        array = new Student[N];

        for(int i = 0; i < N; i++)  {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            array[i] = new Student(name, korean, english, math);
        }

        Arrays.sort(array);

        for (Student student : array) {
            sb.append(student.name).append("\n");
        }

        System.out.println(sb);
    }

    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }


        @Override
        public int compareTo(Student other) {
            if(korean != other.korean) return other.korean - korean;
            if(english != other.english) return english - other.english;
            if(math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
    }
}
