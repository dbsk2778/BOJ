package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmallNumber {

    //정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.

    public static void main(String[] args) {
        List<Integer> smallArr = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int X = scan.nextInt();

        for (int i = 0; i < N; i++) {
            int num = scan.nextInt();
            if (num < X) {
                smallArr.add(num);
            }
        }
        scan.close();

        for (int num : smallArr) {
            System.out.print(num + " ");
        }
    }
}
