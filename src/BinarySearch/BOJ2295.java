package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ2295 {
    public static void main(String[] args) throws IOException {
//        solution();
        solution2();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int maxNum = Integer.MIN_VALUE;

        Set<Integer> twoSumSet = new HashSet<>();

        // 모든 두 수의 합을 구함
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                twoSumSet.add(arr[i] + arr[j]);
            }
        }

        // 세 번째 수를 선택하고, twoSumSet에서 가능한 값을 찾음
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (twoSumSet.contains(arr[i] - arr[j])) {
                    maxNum = Math.max(maxNum, arr[i]);
                }
            }
        }

        System.out.println(maxNum);
    }

    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 모든 연속된 부분 배열의 합을 저장 : 삼각수 (Triangular Number) 공식
        int[] sums = new int[N * (N + 1) / 2];
        int sumIndex = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sums[sumIndex++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(sums);

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 어떤 두 요소 간의 차이가 특정 부분 배열의 합과 일치하는지를 확인
                // 결국 값 - 두개의 합 = 배열에 있는 값이라는 건 세 개의 수를 더한 값이 배열에 존재한다는 것
                int target = arr[i] - arr[j];
                if (isExist(sums, target)) {
                    answer = Math.max(answer, arr[i]);
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean isExist(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) left = mid + 1;
            else if (arr[mid] > target) right = mid - 1;
            else return true;
        }
        return false;
    }

}
