package BOJStep.Level8;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2869 {
    public static void main(String[] args) throws IOException {
        solution2();
    }

    // 시간 초과
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 낮에 올라가는 정도
        int B = Integer.parseInt(st.nextToken()); // 밤에 미끄러지는 정도
        int V = Integer.parseInt(st.nextToken()); // 달팽이가 올라갈 높이
        int num = 0;
        int day = 0;

        while (V > num) {
            num += A;
            if (num < V) num -= B;
            day++;
        }

        bw.write(day + "\n");
        bw.flush();
    }

    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 낮에 올라가는 정도
        int B = Integer.parseInt(st.nextToken()); // 밤에 미끄러지는 정도
        int V = Integer.parseInt(st.nextToken()); // 달팽이가 올라갈 높이

        int day = (int) Math.ceil((double) (V - B) / (A - B));

        bw.write(day + "\n");
        bw.flush();
    }
}
