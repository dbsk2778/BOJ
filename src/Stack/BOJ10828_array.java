package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10828_array {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[10000];

        // Array로 Stack을 구현하려면 이게 제일 중요한 개념임 !!
        int topIndex = -1; // -1 이면 top이 존재하는 인덱스, 0이면 top이 추가되어야 하는 인덱스

        while (N-- > 0) {
            String[] strs = br.readLine().split(" ");

            switch (strs[0]) {
                case "push" -> stack[++topIndex] = Integer.parseInt(strs[1]);
                case "pop" -> sb.append(topIndex < 0 ? -1 : stack[topIndex--]).append("\n");
                case "size" -> sb.append(topIndex + 1).append("\n");
                case "empty" -> sb.append(topIndex == -1 ? 1 : 0).append("\n");
                default -> sb.append(topIndex < 0 ? -1 : stack[topIndex]).append("\n");
            }
        }
        System.out.println(sb);
    }
}