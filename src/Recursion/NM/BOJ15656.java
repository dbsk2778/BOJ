package Recursion.NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15656 {
    public static void main(String[] args) throws IOException {
        // 중복 허용
        solution();
    }

    static int n, m;
    static int[] numbers;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        numbers = new int[n];
        output = new int[m];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        recursion(0);
        System.out.println(sb);
    }

    private static void recursion(int depth) {
        // base case
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            output[depth] = numbers[i];
            recursion(depth + 1);
        }
    }
}
