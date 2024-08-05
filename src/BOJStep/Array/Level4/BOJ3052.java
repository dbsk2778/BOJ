package BOJStep.Array.Level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3052 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 나머지는 0 ~ 41까지 가능
        int[] arr = new int[42];
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine()) % 42;
            arr[num] = 1;
        }
        int count = 0;
        for (int i : arr) {
            if (i == 1) count++;
        }

        System.out.println(count);
    }
}
