package 생활코딩.BRONZE3.Day1;

import java.io.*;

public class BOJ1085 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");

        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        int w = Integer.parseInt(arr[2]);
        int h = Integer.parseInt(arr[3]);

        // 가장 작은 좌표는 (0, 0) 이므로 x, y 그대로 쓰면 됨
        int distanceToRight = w - x; // x 좌표에서 오른쪽 경계선까지의 거리
        int distanceToTop = h - y; // y 좌표에서 위쪽 경계선까지의 거리

        // 네 가지 거리 중 최소값 찾기
        int min = Math.min(Math.min(x, y), Math.min(distanceToRight, distanceToTop));

        bw.write(min + "\n");
        bw.flush();
    }
}
