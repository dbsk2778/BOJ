package BOJStep.Advanced;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3003 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    // BufferedWriter 사용
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] chess = {1, 1, 2, 2, 2, 8};
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            chess[i] -= Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {
            bw.write(chess[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    // StringBuilder 사용 - 출력 시 for 문이 사라지니까 시간 적게 걸림
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] chess = {1, 1, 2, 2, 2, 8};
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            sb.append(chess[i] - Integer.parseInt(st.nextToken())).append(" ");
        }

        System.out.println(sb);
    }
}
