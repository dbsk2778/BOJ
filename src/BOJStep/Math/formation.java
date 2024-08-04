package BOJStep.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class formation {
    public static void main(String[] args) throws IOException {
        BOJ2745();
        BOJ11005();
    }

    public static void BOJ2745() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        System.out.println(Integer.parseInt(N, B));
    }

    public static void BOJ11005() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while (N > 0) {
            int digit = N % B;
            if (digit < 10) sb.append(digit);
            else {
                digit = digit - 10 + 'A';
                sb.append((char) digit);
            }
            N /= B;
        }
        System.out.println(sb.reverse());
    }
}
