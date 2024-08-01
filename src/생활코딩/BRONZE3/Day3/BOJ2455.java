package 생활코딩.BRONZE3.Day3;

import java.io.*;

public class BOJ2455 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = Integer.MIN_VALUE;
        int num = 0;
        for (int i = 0; i < 4; i++) {
            String[] arr = br.readLine().split(" ");

            int up = Integer.parseInt(arr[1]);
            int down = Integer.parseInt(arr[0]);

            num = num + (up - down);

            if (num > max) max = num;
        }
        bw.write(max + "\n");
        bw.flush();
    }
}
