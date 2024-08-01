package 생활코딩.BRONZE3.Day4;

import java.io.*;

public class BOJ15894 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(br.readLine());

        bw.write(4 * n + "\n");
        bw.flush();
    }
}
