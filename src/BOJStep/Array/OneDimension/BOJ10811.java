package BOJStep.Array.OneDimension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10811 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N];

        for (int i = 0; i < N; i++) basket[i] = i + 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            reverse(basket, first - 1, last - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : basket) sb.append(i).append(" ");

        System.out.println(sb.toString());
    }

    private static void reverse(int[] basket, int first, int last) {
        while (first < last) {
            int temp = basket[first];
            basket[first] = basket[last];
            basket[last] = temp;
            first++;
            last--;
        }
    }
}
