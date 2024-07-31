package 생활코딩.BRONZE3.Day1;

import java.io.*;
import java.util.Scanner;

public class BOJ10818 {
    public static void main(String[] args) throws IOException {
        solution();
        solution2();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String s : inputs) {
            int i = Integer.parseInt(s);
            if (i < min) min = i;
            if (i > max) max = i;
        }

        bw.write(min + " " + max + "\n");
        bw.flush();
    }

    public static void solution2() {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int num = scan.nextInt();

            if (num < min) min = num;
            if (num > max) max = num;
        }

        System.out.println(min + " " + max);
    }
}
