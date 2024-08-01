package BOJStep.For;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class printStar {
    public static void main(String[] args) throws IOException {
//        star1();
        star2();
    }

    public static void star1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void star2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = N - i; j <= N; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

//        int num = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < num; i++) {
//            for (int j = num - 1; j > i; j--) {
//                System.out.print(" ");
//            }
//            for (int k = 0; k <= i; k++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
    }
}
