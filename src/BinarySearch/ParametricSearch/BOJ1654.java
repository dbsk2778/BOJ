package BinarySearch.ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {

    public static void main(String[] args) throws IOException {
        // 랜선 자르기 : 길이가 제각각인 K개의 랜선으로 N개의 같은 길이의 랜선으로 만들 때 만들 수 있는 최대 랜선의 길이
//        solution();
        solution2();
    }

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

    // 주어진 N개의 개수로 나눌 수 있는 최대의 값을 구하는 문제이기 때문에 파라메트릭 서치
    // 만약 answer이 N보다 작으면 랜선의 길이를 줄여야 하고, N 보다 크면 랜선의 길이를 늘려야 함
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

    // 강의 정답
    // 시간 복잡도 O(N * logL)
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 이미 가지고 있는 랜선의 개수 K, 필요한 랜선의 개수 N
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] lengths = new long[K];
        long maxLen = 0;
        for (int i = 0; i < K; i++) {
            lengths[i] = Long.parseLong(br.readLine());
            if (maxLen < lengths[i]) maxLen = lengths[i];
        }

        long left = 1; // 0으로 나눌 수 없음
        long right = maxLen; // (1L << 31) - 1 : 2의 31승 -1의 값임
        long answer = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (calculateCount(lengths, mid) >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    // 판정 함수
    // 랜선 길이를 입력받아서 내가 원하는 길이로 잘라보는 함수
    private static long calculateCount(long[] lengths, long cutLength) {
        long count = 0;
        for (long length : lengths) {
            count += length / cutLength;
        }
        // 만들 수 있는 랜선의 개수 : 이건 다 잘라봐야함 = O(N)
        return count;
    }
}
