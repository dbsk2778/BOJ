package 생활코딩.BRONZE3.Day3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2914 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        String[] arr = br.readLine().split(" ");
//        int A = Integer.parseInt(arr[0]);
//        int I = Integer.parseInt(arr[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());

        bw.write(A * (I - 1) + 1 + "\n");

        bw.flush();
//        bw.close();
//        br.close();
    }
}
