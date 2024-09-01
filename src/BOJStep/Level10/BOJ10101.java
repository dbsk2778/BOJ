package BOJStep.Level10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10101 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());

        findTriangle(x, y, z);
    }

    private static void findTriangle(int x, int y, int z) {
        String triangle = "Scalene";
        if (x + y + z != 180) {
            triangle = "Error";
        } else if (x == y && y == z) {
            triangle = "Equilateral";
        } else if (x == y || x == z || y == z) {
            triangle = "Isosceles";
        }
        System.out.println(triangle);
    }
}
