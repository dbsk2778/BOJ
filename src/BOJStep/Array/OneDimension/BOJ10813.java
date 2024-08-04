package BOJStep.Array.OneDimension;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10813 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] basket = new int[n];

        for (int i = 0; i < n; i++) basket[i] = i + 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;

            change(basket, first, second);
        }

        for (int i = 0; i < n; i++) {
            bw.write(basket[i] + " ");
        }
        bw.flush();
    }

    private static void change(int[] basket, int first, int second) {
        int temp = basket[first];
        basket[first] = basket[second];
        basket[second] = temp;
    }
}
