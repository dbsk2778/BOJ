package 생활코딩.BRONZE3.Day4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2576 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num % 2 == 1) {
                sum += num;
                if (num < min) min = num;
            }
        }

        if (sum > 0) {
            bw.write(sum + "\n");
            bw.write(min + "\n");
        } else {
            bw.write(-1 + "\n");
        }
        bw.flush();
    }
}
