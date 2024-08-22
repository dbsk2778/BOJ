package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470_TwoPointer {
    public static void main(String[] args) throws IOException {
        solution();
    }

    // 투 포인터 기법 - 정렬된 배열에서 두 개의 포인터를 사용하여 특정 조건에 만족하는 값을 효율적으로 찾는 데 사용
    // 투 포인터 기법은 정렬된 배열에서 좌우에서 시작하는 두 포인터를 움직이며 조건을 만족하는 값을 찾는 방식입니다
    // 두 수의 합이 특정 값에 가장 가까운 쌍을 찾는 문제에서 매우 효과적
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터 기법을 사용하려면 정렬되어 있어야 함
        Arrays.sort(arr);

        int left = 0; // 배열의 첫번째 요소
        int right = N - 1; // 배열의 마지막 요소
        int minSum = Integer.MAX_VALUE;  // 최소 값 변수 초기화, 현재 발견 된 두 수의 합에서 0에 가장 가까운 값 저장
        int answer1 = 0;
        int answer2 = 0;

        // left 포인터와 right 포인터가 만나기 전까지 반복
        while (left < right) {
            // 두 수의 합을 계산하고
            int sum = arr[left] + arr[right];

            // 더 적은 절댓값을 찾으면 값 저장해줌
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                answer1 = arr[left];
                answer2 = arr[right];
            }

            // sum이 0보다 작으면 left 포인터를 오른쪽으로 이동시켜 더 큰 값을 더하도록 함
            if (sum < 0) left++;
                // sum이 0보다 크면 right 포인터를 왼쪽으로 이동시켜 더 작은 값을 더하도록 함
            else right--;
        }

        System.out.println(answer1 + " " + answer2);
    }
}
