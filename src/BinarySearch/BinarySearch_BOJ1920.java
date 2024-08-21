package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BinarySearch_BOJ1920 {
    public static void main(String[] args) throws IOException {
        solution();
        solution2();
        solution3();
    }

    // binary Search 사용
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // binary search를 사용하기 위해서는 배열이 항상 정렬된 상태여야 함
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean isExist = isExist(arr, num);
            sb.append(isExist ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isExist(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] > num) {
                right = mid - 1;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }


    // Set 사용
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) set.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(set.contains(num) ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    // Arrays.binarySearch(arr, num) 사용
    public static void solution3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // binary search를 사용하기 위해서는 배열이 항상 정렬된 상태여야 함
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            // Arrays.binarySearch() 메서드는 0 이상인 값이면 값이 존재하는 것
            sb.append(Arrays.binarySearch(arr, num) >= 0 ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }
}
