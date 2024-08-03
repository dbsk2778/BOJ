package BOJStep.Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int groupWordCount = 0;

        for (int i = 0; i < N; i++) {
            if (isGroupWord(br.readLine())) {
                groupWordCount++;
            }
        }

        System.out.println(groupWordCount);
    }

    public static boolean isGroupWord(String word) {
        boolean[] seen = new boolean[26];
        char lastChar = '\0';

        for (char c : word.toCharArray()) {
            if (c != lastChar) {
                if (seen[c - 'a']) { // true 이미 값이 나왔을 때
                    return false;
                }
                seen[c - 'a'] = true;
                lastChar = c;
            }
        }
        return true;
    }
}