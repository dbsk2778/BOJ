package BinarySearch.BOJ10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10816_BinarySearch {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = stringToInt(br.readLine());

        int[] havingCard = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            havingCard[i] = stringToInt(st.nextToken());
        }

        Arrays.sort(havingCard);

        int M = stringToInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int findNum = stringToInt(st.nextToken());
            sb.append(countNum(havingCard, findNum));

            if (i != M - 1) sb.append(" ");
        }

        System.out.println(sb);
    }

    private static int stringToInt(String s) {
        return Integer.parseInt(s);
    }

    private static int countNum(int[] arr, int value) {
        int firstIndex = findFirst(arr, value);
        if (firstIndex == -1) return 0;

        int lastIndex = findLast(arr, value);
        return lastIndex - firstIndex + 1;
    }

    private static int findFirst(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < value) left = mid + 1;
            else if (arr[mid] > value) right = mid - 1;
            else {
                result = mid; // 일치하는 경우 위치를 기록하고 왼쪽을 계속 탐색
                right = mid - 1;
            }
        }
        return result;
    }

    private static int findLast(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < value) left = mid + 1;
            else if (arr[mid] > value) right = mid - 1;
            else {
                result = mid; // 일치하는 경우 위치를 기록하고 오른쪽을 계속 탐색
                left = mid + 1;
            }
        }
        return result;
    }
}
