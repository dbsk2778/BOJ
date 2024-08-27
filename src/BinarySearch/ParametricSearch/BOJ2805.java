package BinarySearch.ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    // 이진 탐색을 활용하여 문제의 답을 해결해야 함
    public static void solution() throws IOException {
        // 나무의 수 N + 나무의 길이 M
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] trees = new int[N];
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (maxHeight < trees[i]) {
                maxHeight = trees[i];
            }
        }

        int answer = binarySearch(trees, N, M, maxHeight);

        System.out.println(answer);
    }

    private static int binarySearch(int[] trees, int N, int M, int maxHeight) {
        int low = 0;
        int high = maxHeight;
        int answer = 0;

        while (low <= high) {
            // int mid = (low + high) / 2;
            int mid = low + (high - low) / 2;  // 오버플로우 방지
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    sum += (long) trees[i] - mid;  // long 타입 변환으로 정확한 계산
                }
            }

            if (sum >= M) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }
}
