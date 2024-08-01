package 생활코딩.BRONZE3.Day2;

import java.io.*;

public class BOJ10953 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T; i++) {
            String[] arr = br.readLine().split(",");
            int A = Integer.parseInt(arr[0]);
            int B = Integer.parseInt(arr[1]);

            bw.write(A + B + "\n");
        }
        bw.flush();
    }
}
