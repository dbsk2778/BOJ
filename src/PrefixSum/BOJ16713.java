package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16713 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    // XOR > 비트 연산 (같은 값 연산 0, 다른 값 연산 1)
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] acc = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            // XOR 연산의 순서는 상관 없다
            acc[i] = acc[i - 1] ^ Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            ans ^= acc[j] ^ acc[i - 1]; // 복원
        }

        System.out.println(ans);
    }

}
