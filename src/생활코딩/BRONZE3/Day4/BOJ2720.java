package 생활코딩.BRONZE3.Day4;

import java.io.*;

public class BOJ2720 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());

            int Quarter = K / 25;
            int Dime = (K % 25) / 10;
            int Nickel = ((K % 25) % 10) / 5;
            int Penny = K % 5;

            bw.write(Quarter + " " + Dime + " " + Nickel + " " + Penny + "\n");
        }

        bw.flush();
    }
}
