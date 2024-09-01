package 생활코딩.BRONZE3.Day1;

import java.io.*;
import java.util.Arrays;

public class BOJ10817 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Arrays.sort(arr) 을 하면 String 값의 정렬이기 때문에 int형 정렬과 답이 다르게 나올 수 있음 !! 주의하기 !!
        String[] arr = br.readLine().split(" ");

        int[] nums = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(nums);

        bw.write(nums[1] + "\n");
        bw.flush();
    }
}
