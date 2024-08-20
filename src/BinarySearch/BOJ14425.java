package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ14425 {
    public static void main(String[] args) throws IOException {
//        solution();
//        solution2();
        solution3();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) arr[i] = br.readLine();

        Arrays.sort(arr);

        int num = 0;

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (Arrays.binarySearch(arr, s) >= 0) num++;
        }
        System.out.println(num);
    }

    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) set.add(br.readLine());

        int num = 0;

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (set.contains(s)) num++;
        }
        System.out.println(num);
    }

    public static void solution3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) arr[i] = br.readLine();

        Arrays.sort(arr);

        int num = 0;

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (isExist(arr, s)) num++;
        }

        System.out.println(num);
    }

    private static boolean isExist(String[] arr, String s) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = arr[mid].compareTo(s);

            // str1.compareTo(str2)이 0이면 str1과 str2가 동일
            // str1.compareTo(str2)이 음수이면 str1이 str2보다 사전 순서상 앞에 있음
            // str1.compareTo(str2)이 양수이면 str1이 str2보다 사전 순서상 뒤에 있음
            if (comparison < 0) {
                // arr[mid]가 s보다 앞에 있음
                left = mid + 1;
            } else if (comparison > 0) {
                // arr[mid]가 s보다 뒤에 있음
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
