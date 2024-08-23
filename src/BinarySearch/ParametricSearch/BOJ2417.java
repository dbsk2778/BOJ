package BinarySearch.ParametricSearch;

import java.util.Scanner;

public class BOJ2417 {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(calcIntegerSqrt(n));
    }

    private static long calcIntegerSqrt(long n) {
        if (n == 0) return 0;

        long left = 1;
        long right = n;
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (Math.pow( mid, 2) >= n) {
                right = mid - 1;
                answer = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return answer;
    }

    // long의 범위 벗어나서 overflow 에러 발생
    private static boolean isIntegerSqrt(long n, long q) {
        return q * q >= n;
    }
}
