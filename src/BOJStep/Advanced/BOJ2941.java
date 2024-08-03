package BOJStep.Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String a : alpha) {
            word = word.replace(a, "*"); // 크로아티아 알파벳을 '*'로 대체
        }

        System.out.println(word.length()); // 최종 문자열의 길이를 출력
    }
}
