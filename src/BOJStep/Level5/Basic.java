package BOJStep.Level5;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Basic {

    public static void main(String[] args) throws IOException {
        BOJ27866();
        BOJ2743();
        BOJ9086();
        BOJ1152();
        BOJ1152_2();
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
            bw.write(str.charAt(0) + "" + str.charAt(str.length() - 1) + "\n");
        }
        bw.flush();
    }

    public static void BOJ1152() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        // isBlank()와 toList()는 자바 17버전에서만 사용 가능, 11버전 불가
        List<String> l = Arrays.stream(strs).filter(str -> !str.isBlank()).toList();

        System.out.println(l.size());
    }

    public static void BOJ1152_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.println(st.countTokens());
    }
}
