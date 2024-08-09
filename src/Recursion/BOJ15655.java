package Recursion;

import java.io.*;
import java.util.*;

public class BOJ15655 {
    public static void main(String[] args) throws IOException {
        // 고른 수열이 전부 다 오름차순이여야 한다.
        // 1. 출력 직전에 오름차순 검사 (시간 복잡도 매우 높음)
        // 2. 재귀를 오름차순으로만 진입할 수 있게 조건 변경 (재귀 이전에 sort 해주고, 제약 조건 주기) - 기존보다 시간복잡도 낮아짐
        solution();
    }

    static int n, m;
    static int[] arr;
    static boolean[] isUsed;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        isUsed = new boolean[n];
        output = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        recursion(0, 0);
        System.out.println(sb);
    }

    // 오름차순으로 정렬된 값만 출력하기 위해 start 변수 추가
    private static void recursion(int depth, int start) {
        // baseCase
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                output[depth] = arr[i];
                // i + 1으로 함으로써 자신보다 큰 수로 재귀 범위를 줄이기
                recursion(depth + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }
}
