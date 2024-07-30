package 생활코딩.BRONZE3.Day1;

import java.io.*;
import java.util.Scanner;

public class BOJ2884 {
    public static void main(String[] args) throws IOException {
        solution();
        solution2();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strs = br.readLine().split(" ");
        int H = Integer.parseInt(strs[0]);
        int M = Integer.parseInt(strs[1]);

        int max = 24 * 60;
        int sum = H * 60 + M;
        int time = sum - 45;
        if (time < 0) {
            sum = max + time;
        } else {
            sum = sum - 45;
        }
        bw.write(sum / 60 + " " + sum % 60 + "\n");
        bw.flush();
    }

    public static void solution2() {
        Scanner scan = new Scanner(System.in);

        int H = scan.nextInt();
        int M = scan.nextInt();

        if (M < 45) {
            M += 60;
            if ( H == 0 ) H = 23;
            else H--;
        }

        M = M - 45;
        System.out.println(H + " " + M);
    }
}
