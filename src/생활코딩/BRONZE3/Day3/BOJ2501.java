package 생활코딩.BRONZE3.Day3;

import java.io.*;

public class BOJ2501 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");

        int N = Integer.parseInt(arr[0]);
        int[] nums = new int[N];
        int K = Integer.parseInt(arr[1]);

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                nums[i - 1] = i;
            }
        }

        int idx = 0;
        int num = 0;
        for (int i : nums) {
            if (i != 0) {
                idx++;
                if (idx == K) num = i;
            }
        }

        bw.write(num + "\n");
        bw.flush();
    }
}
