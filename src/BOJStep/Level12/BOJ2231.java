package BOJStep.Level12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2231 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    // split 시간 개오래걸림 ;;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int N = Integer.parseInt(str);

        int result = 0;
        for (int i = 1; i < N; i++) {
            int sum = 0;
            String[] strs = String.valueOf(i).split("");

            for (String s : strs) {
                sum += Integer.parseInt(s);
            }

            if (sum + i == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int N = Integer.parseInt(str);

        int result = 0;
        for (int i = 1; i < N; i++) {
            int sum = 0;
            int number = i;
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (sum + i == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
