package BOJStep.Level8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2903 {
    public static void main(String[] args) throws IOException {
        solution();
        solution2();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        // Math.pow(거듭제곱할 숫자, 거듭제곱(몇제곱인지)
        System.out.println((int) Math.pow(Math.pow(2, n) + 1, 2));
    }

    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int dot = 2;

        for (int i = 0; i < n; i++) {
            dot += (dot - 1);
        }
        System.out.println(dot * dot);
    }
}
