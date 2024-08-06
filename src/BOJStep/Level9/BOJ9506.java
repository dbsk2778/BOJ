package BOJStep.Level9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ9506 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;
            isPerfectNumber(n, bw);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void isPerfectNumber(int n, BufferedWriter bw) throws IOException {

        List<Integer> l = new ArrayList<>();
        int sum = 0;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                l.add(i);
                sum += i;
            }
        }

        if (sum == n) {
            bw.write(n + " = ");
            for (int i = 0; i < l.size(); i++) {
                bw.write(l.get(i).toString());
                if (i < l.size() - 1) {
                    bw.write(" + ");
                }
            }
            bw.write("\n");
        } else {
            bw.write(n + " is NOT perfect.\n");
        }
    }
}
