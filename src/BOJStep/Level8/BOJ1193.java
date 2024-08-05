package BOJStep.Level8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1193 {
    public static void main(String[] args) throws IOException {
        solution();
        solution2();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int num = 0, sum = 0, count = 0;

        for (int i = 0; i < X; i += num) {
            num++;
            sum += num;
            count++;
        }

        X = sum - X;

        int x, y;
        if (count % 2 == 0) {
            x = count;
            y = 1;
            for (int i = 0; i < X; i++) {
                y++;
                x--;
            }

        } else {
            x = 1;
            y = count;
            for (int i = 0; i < X; i++) {
                y--;
                x++;
            }

        }
        System.out.println(x + "/" + y);
    }

    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int num = 1;

        while ( X > num ) {
            X -= num++;
        }

        if (num % 2 == 0) {
            System.out.println(X + "/" + (num + 1 - X));
        } else {
            System.out.println((num + 1 - X) + "/"  + X);
        }
    }
}
