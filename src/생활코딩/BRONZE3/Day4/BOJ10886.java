package 생활코딩.BRONZE3.Day4;

import java.io.*;

public class BOJ10886 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 설문조사를 한 사람

        int zeros = 0;
        int ones = 0;

        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(br.readLine()) == 0) {
                zeros++;
            } else {
                ones++;
            }
        }

        if (zeros > ones) {
            bw.write("Junhee is not cute!" + "\n");
        } else {
            bw.write("Junhee is cute!" + "\n");
        }

        bw.flush();
    }
}
