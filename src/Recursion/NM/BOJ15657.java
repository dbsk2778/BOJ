package Recursion.NM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15657 {
    public static void main(String[] args) throws IOException {
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
        numbers = new int[n];
        output = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        recursion(0, 0);

        System.out.print(sb);
    }

    private static void recursion(int depth, int start) {
        // base
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // recursion
        for (int i = start; i < n; i++) {
            output[depth] = numbers[i];
            // 같은 숫자가 나와도 되니까 i + 1 이 아니라 i임
            recursion(depth + 1, i);
        }
    }
}
