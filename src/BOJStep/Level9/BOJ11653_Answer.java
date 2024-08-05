package BOJStep.Level9;

import java.io.*;

public class BOJ11653_Answer {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                bw.write(i + "\n");
                N /= i;
            }
        }

        if (N > 1) {
            bw.write(N + "\n");
        }

        bw.flush();
    }
}
