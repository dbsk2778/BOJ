package BinarySearch.ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    // 정렬하지 않은 이분 탐색 시간초과 뜸
    public static void solution() throws IOException {
        // 만들 수 있는 최대 랜선의 길이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 이미 가지고 있는 랜선의 개수 K, 필요한 랜선의 개수 N
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] lans = new long[K];
        long maxLen = 0;
        for (int i = 0; i < K; i++) {
            lans[i] = Long.parseLong(br.readLine());
            if (maxLen < lans[i]) maxLen = lans[i];

        }

        long answer = binarySearch(lans, K, N, maxLen);
        System.out.println(answer);
    }

    private static long binarySearch(long[] lans, int K, int N, long maxLen) {
        long answer = 0;
        long low = 1;
        long high = maxLen;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = 0;

            for (int i = 0; i < K; i++) {
                count += lans[i] / mid;
            }

            if (count >= N) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

}
