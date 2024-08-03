package BOJStep.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10807 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        String V = br.readLine();

        int count = 0;
        for (String str : strs) {
            if (str.equals(V)) count += 1;
        }

        System.out.println(count);
    }
}
