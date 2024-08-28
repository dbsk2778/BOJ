package BinarySearch.ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        // 어떤 조건을 만족하는 최솟값, 최댓값의 문제가 있을 때는 이 문제가 파라메트릭 서치로 해결될 수 있는가를 확인해야 함
        // 나무 자르기 문제는 M미터 이상의 나무를 가져갈 수 있는 절단기 높이의 최댓값을 의미
        // solution();
        solution2();
    }

    // 나무 높이의 범위가 10억이기 때문에 모든 값을 확인하면 시간초과 일어남
    // 이진 탐색을 활용하여 문제의 답을 해결해야 함
    // 이게 조금 더 빠름 !!
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

    // 시간 복잡도 O(N * logH)
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }


        // 1. 절단기 높이의 탐색 범위를 정하기
        int left = 0;
        int right = 1000000000; // 나무 최대의 길이 임의로 지정하거나 들어온 최댓값으로 하거나 둘 중 하나
        int answer = -1; // 무조건 한번은 갱신 되니까 아무 값이나 해줘도 됨 (나올 수 없는 값이면 더 좋음)

        // 2. 판정 함수 : sum이 M보다 작다면 더 잘라내야 하고(절단기 높이 낮추기), sum이 M보다 크다면 H는 답의 후보가 됨(보다 높은 H에서 가능한지 조사)
        while (left <= right) {
            int mid = (left + right) / 2;  // 임의의 절단기 높이
            if (isPossible(heights, mid, M)) {
                answer = mid; // 이 높이는 답이 가능한 높이
                left = mid + 1; // 만족하는 더 큰 값이 있는지 확인
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }


    // 강의 - 내가 원하는 만큼의 나무를 가져갈 수 있는 cutHeight 인가를 확인하는 메서드
    // 시간 복잡도 O(N)
    private static boolean isPossible(int[] heights, int cutHeight, int M) {
        long sum = 0; // 나무의 범위가 10억이니까 세개만 넘어가도 Integer의 범위 넘어감
        for (int height : heights) {
            if (height > cutHeight) sum += height - cutHeight;
        }
        return sum >= M;
    }
}
