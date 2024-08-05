package BOJStep.Array.Level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10798 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][15];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
//            arr[i] = new char[s.length()];
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (arr[i][j] != '\0') {  // 기본 값이 아닌 문자만 추가
                    sb.append(arr[i][j]);
                }
            }
        }

        System.out.println(sb);
    }
}
