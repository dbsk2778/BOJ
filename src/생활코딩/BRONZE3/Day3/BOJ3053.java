package 생활코딩.BRONZE3.Day3;

import java.io.*;

public class BOJ3053 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int R = Integer.parseInt(br.readLine());
        double pie = Math.PI;

//        System.out.printf("%.6f\n", pie * R * R);
//        System.out.printf("%.6f\n", 2.0 * R * R);

        String a = String.format("%.6f", pie * R * R);
        String b = String.format("%.6f", 2.0 * R * R);

        bw.write(a + "\n");
        bw.write(b + "\n");

        bw.flush();
    }
}
