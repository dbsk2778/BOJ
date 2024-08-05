package BOJStep.Level10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5073 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[3];
        while (true) {
            st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;

            Arrays.sort(arr);

            System.out.println(judgeTriangle(arr));
        }
    }

    private static String judgeTriangle(int[] arr) {
        int x = arr[0];
        int y = arr[1];
        int z = arr[2];

        if (z >= x + y) {
            return "Invalid";
        }

        if (x == y && y == z) {
            return "Equilateral";
        }

        if (x == y || x == z || y == z) {
            return "Isosceles";
        }

        return "Scalene";
    }
}
