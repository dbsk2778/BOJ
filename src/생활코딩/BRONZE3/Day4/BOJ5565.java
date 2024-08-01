package 생활코딩.BRONZE3.Day4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ5565 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalPrice = Integer.parseInt(br.readLine());
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            totalPrice -= Integer.parseInt(st.nextToken());
        }
        System.out.println(totalPrice);
    }
}
