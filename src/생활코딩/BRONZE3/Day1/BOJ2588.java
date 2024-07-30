package 생활코딩.BRONZE3.Day1;

import java.io.*;
import java.util.Scanner;

public class BOJ2588 {

    public static void main(String[] args) throws IOException {
        solution();
        solution2();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int one = m % 10 * n;
        int two = (m % 100) / 10 * n;
        int three = m / 100 * n;

        bw.write(one + "\n");
        bw.write(two + "\n");
        bw.write(three + "\n");
        bw.write(one + (two * 10) + (three * 100) + "\n");

        bw.flush();
    }

    public static void solution2() {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        char[] m = scan.next().toCharArray();
        int sum = 0;
        int k = 1;
        for (int i = 2; i >= 0; i--) {
            int l = Integer.parseInt(String.valueOf(m[i])) * n;
            System.out.println(l);
            sum = sum + (l * k);
            k *= 10;
        }

        System.out.println(sum);
    }
}
