package 생활코딩.BRONZE3.Day3;

import java.io.*;

public class BOJ10162 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        if (T % 10 != 0) {
            bw.write(-1 + "\n");
        } else {
            int A = T / 300;
            int B = (T % 300) / 60;
            int C = (T % 60) / 10;
            bw.write(A + " " + B + " " + C + "\n");
        }
        bw.flush();
    }
}
