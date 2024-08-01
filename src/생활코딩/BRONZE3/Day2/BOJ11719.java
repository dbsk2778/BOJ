package 생활코딩.BRONZE3.Day2;

import java.io.*;

public class BOJ11719 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while ((s = br.readLine()) != null) {
            bw.write(s + "\n");
        }
        bw.flush();
    }
}
