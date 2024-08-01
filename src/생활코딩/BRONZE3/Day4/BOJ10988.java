package 생활코딩.BRONZE3.Day4;

import java.io.*;

public class BOJ10988 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        int len = word.length();
        boolean isPalindrome = true;
        for (int i = 0; i < len; i++) {
            boolean isMatch = word.charAt(i) == word.charAt(len - i - 1);

            if (!isMatch) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) bw.write(1 + "\n");
        if (!isPalindrome) bw.write(0 + "\n");

        bw.flush();
    }
}
