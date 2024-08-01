package 생활코딩.BRONZE3.Day2;

import java.io.*;

public class BOJ10810 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);

        int[] nums = new int[N];
        int M = Integer.parseInt(NM[1]);
        for (int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(" ");
            putBalls(nums, arr);
        }

        for (int num : nums) {
            bw.write(num + " ");
        }
        bw.write("\n");
        bw.flush();
    }

    public static void putBalls(int[] nums, String[] arr) {
        int I = Integer.parseInt(arr[0]);
        int J = Integer.parseInt(arr[1]);
        int K = Integer.parseInt(arr[2]);

        for (int basket = I; basket <= J; basket++) {
            nums[basket - 1] = K;
        }
    }
}
