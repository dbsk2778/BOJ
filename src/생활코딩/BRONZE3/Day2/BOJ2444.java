package 생활코딩.BRONZE3.Day2;

import java.util.Scanner;

public class BOJ2444 {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        printStar(N);
    }

    public static void printStar(int N) {
        for (int i = 0; i < N; i++) {
            System.out.println(2 * i + 1);
        }

        for (int i = N - 2; i >= 0; i--) {
            System.out.println(2 * i + 1);
        }
    }
}
