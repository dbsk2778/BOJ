package 생활코딩.BRONZE3.Day1;

import java.util.Scanner;

public class BOJ2441 {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < N - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
