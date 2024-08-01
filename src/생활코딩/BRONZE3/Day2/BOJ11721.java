package 생활코딩.BRONZE3.Day2;

import java.util.Scanner;

public class BOJ11721 {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        for (int i = 0; i < str.length(); i += 10) {
            int maxLength = Math.min(i + 10, str.length());
            System.out.println(str.substring(i, maxLength));
        }
    }

}
