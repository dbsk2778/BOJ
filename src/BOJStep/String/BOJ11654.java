package BOJStep.String;

import java.io.*;
import java.util.Arrays;

public class BOJ11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i) - 'a'] < 0) arr[str.charAt(i) - 'a'] = i;
        }

        for (int i : arr) bw.write(i + " ");
        bw.flush();
    }

}
