package BOJStep.String;

import java.io.*;
import java.util.Scanner;

public class Basic {

    public static void main(String[] args) throws IOException {
        BOJ27866();
        BOJ2743();
        BOJ9086();
    }

    public static void BOJ27866() {
        Scanner scan = new Scanner(System.in);
        String S = scan.next();
        int i = scan.nextInt();

        System.out.println(S.charAt(i - 1));
    }

    public static void BOJ2743() {
        Scanner scan = new Scanner(System.in);
        String S = scan.next();

        System.out.println(S.length());
    }

    public static void BOJ9086() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            bw.write(str.charAt(0) + "" + str.charAt(str.length()-1) + "\n");
        }
        bw.flush();
    }
}
