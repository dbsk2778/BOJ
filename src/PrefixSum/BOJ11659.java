package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11659 {
    public static void main(String[] args) throws IOException {
        // solution();
        prefixSum();
    }

    // 시간 초과 발생 - 시간 복잡도 O(N * M)
    // 여기선 N과 M의 범위가 10만이기 때문에 시간 초과 발생 (1억번 훨씬 이상)
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }


        for (int i = 0; i < M; i++) {
            long sum = 0;

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start - 1; j < end; j++) sum += list.get(j);

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    public static void prefixSum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[N + 1]; // 1-based index 사용

        st = new StringTokenizer(br.readLine());

        // 누적합을 구할때 인덱스를 0부터 시작하기보다는 1부터 시작하는게 더 좋음
        // 시간 복잡도 O(N)
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 구간합 계산 시간 복잡도 : O(1)
            sb.append(prefixSum[end] - prefixSum[start - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
