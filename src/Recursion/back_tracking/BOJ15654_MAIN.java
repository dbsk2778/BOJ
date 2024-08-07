package Recursion.back_tracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654_MAIN {
    public static void main(String[] args) throws IOException {
        solution();
    }

    static int n, m;
    static int[] arr;
    static boolean[] isUsed;
    // 뽑은 수가 담긴 배열 - 이 의미는 3개를 뽑아라고 하면 3개의 숫자가 담겨있음 !! (하나의 줄, 하나의 케이스를 담는 공간임)
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

        recursion(0);
        // 출력을 여기서 한번만 해주는게 훨씬 더 좋음
        System.out.println(sb);
    }

    private static void recursion(int depth) {
        // m개를 다 뽑았을 때 (Base Case)
        // 원하는 숫자를 뽑았으니 출력해주면 됨
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            // System.out.println(sb);
            sb.append("\n");
            return;  // 더 이상 숫자를 뽑으면 안됨
        }
        for (int i = 0; i < n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                // output은 안비워줘도 되는건가? 당연히 같은 자리에 다른 숫자 들어감 !!
                output[depth] = arr[i];
                recursion(depth + 1);
                isUsed[i] = false;
            }
        }
    }
}
