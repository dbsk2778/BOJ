package 생활코딩.BRONZE3.Day1;

import java.io.*;

public class BOJ10250 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] arr = br.readLine().split(" ");
            bw.write(getRoom(arr) + "\n");
        }

        bw.flush();
    }

    public static String getRoom(String[] arr) {
        // H(층 수), W(방의 개수), N(몇번째 손님)
        int H = Integer.parseInt(arr[0]);
        int N = Integer.parseInt(arr[2]);

        int floor = N % H == 0 ? H : N % H;
        int roomNum = (N - 1) / H + 1;

        return floor + String.format("%02d", roomNum);
    }
}
