package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2751 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    // Arrays.sort()의 시간 복잡도는 최소 NlogN에서 최대 N2임 -> 시간 복잡도 중요
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        for (int i = 0; i < N - 1; i++) {
            sb.append(numbers[i]).append("\n");
        }
        sb.append(numbers[N - 1]);
        System.out.println(sb);
    }
}
