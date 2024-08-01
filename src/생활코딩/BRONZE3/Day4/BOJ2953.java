package 생활코딩.BRONZE3.Day4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2953 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int max = Integer.MIN_VALUE;
        int cookerNum = 1;
        for (int i = 1; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int sum = a + b + c + d;

            if (sum > max) {
                max = sum;
                cookerNum = i;
            }
        }
        bw.write(cookerNum + " " + max + "\n");
        bw.flush();
    }
}
