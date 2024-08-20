package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] prefixSum = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                // prefixSum[i - 1][j - 1] : 중복되는 부분 빼주기
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int minX = Integer.parseInt(st.nextToken());  // x1
            int minY = Integer.parseInt(st.nextToken());  // y1
            int maxX = Integer.parseInt(st.nextToken());  // x2
            int maxY = Integer.parseInt(st.nextToken());  // y2

            // [x2][y2] - [x1-1][y2] - [x2][y1-1] + [x1-1][y1-1];
            int sum = prefixSum[maxX][maxY] - prefixSum[minX - 1][maxY] - prefixSum[maxX][minY - 1] + prefixSum[minX - 1][minY - 1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
