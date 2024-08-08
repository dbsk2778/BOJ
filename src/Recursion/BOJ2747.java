package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2747 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    private static final int[] arr = new int[50];

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        if (n == 0) return 0;

        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return arr[n];
    }
}
