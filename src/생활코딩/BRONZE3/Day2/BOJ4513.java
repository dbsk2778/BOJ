package 생활코딩.BRONZE3.Day2;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ4513 {
    public static void main(String[] args) {
        solution();
        solution2();
    }

    public static void solution() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String[] arr = scan.nextLine().split(" ");

            int[] intArr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                intArr[i] = Integer.parseInt(arr[i]);
            }

            Arrays.sort(intArr);

            int x = intArr[0];
            int y = intArr[1];
            int z = intArr[2];

            if (x == 0 && y == 0 && z == 0) {
                break;
            }
            if ((x * x) + (y * y) == (z * z)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }

    public static void solution2() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String[] arr = scan.nextLine().split(" ");

            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            int z = Integer.parseInt(arr[2]);

            if (x == 0 && y == 0 && z == 0) {
                break;
            }

            // 새로운 배열 만드는 방법 **
            int[] sides = {x, y, z};
            Arrays.sort(sides);

            if ((sides[0] * sides[0]) + (sides[1] * sides[1]) == (sides[2] * sides[2])) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
