package 생활코딩.BRONZE3.Day3;

import java.io.*;

public class BOJ2566 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(arr[j]);
                if (num > max)  {
                    max = num;
                    x = i;
                    y = j;
                }
            }
        }

        bw.write(max + "\n");
        bw.write((x + 1) + " " + (y + 1) + "\n");
        bw.flush();
    }
}
