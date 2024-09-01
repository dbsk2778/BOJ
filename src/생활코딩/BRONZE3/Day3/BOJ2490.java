package 생활코딩.BRONZE3.Day3;

import java.io.*;

public class BOJ2490 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            String[] arr = br.readLine().split(" ");

//            long count = Arrays.stream(arr)
//                    .filter("0"::equals)
//                    .count();

            // stream 보다 조금 더 빠름
            long count = 0;
            for (String s : arr) {
                if (s.equals("0")) count++;
            }

            bw.write(getStatus(count) + "\n");
        }
        bw.flush();
    }

    public static String getStatus(long count) {
        // 0의 개수
        // 0이 1이면 - A(도), 0이 2면 B(개), 0이 3개면 걸(C), 0이 4개면 윷 : D
        if (count == 1) return "A";
        if (count == 2) return "B";
        if (count == 3) return "C";
        if (count == 4) return "D";
        return "E";
    }
}
