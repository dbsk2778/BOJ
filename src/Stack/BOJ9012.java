package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ9012 {
    // 올바른 괄호 쌍 찾기
    // 가장 최근에 열린 괄호가 가장 먼저 닫힌다.
    // 모든 열린 괄호가 닫힌 괄호와 쌍을 이룬다.
    // 시간 복잡도는 N !!
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split("");
            boolean isValid = isValid(strs);

            if (!isValid) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isValid(String[] strs) {
        Deque<String> stack = new ArrayDeque<>();
        boolean isValid = true;

        for (String str : strs) {
            if (str.equals("(")) {
                stack.addLast("(");
            } else if (str.equals(")")) {
                // 비어 있을 경우 처리 꼭 해줘야 함 !!
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                stack.removeLast();
            }
        }

        if (!stack.isEmpty()) {
            isValid = false;
        }

        return isValid;
    }
}
