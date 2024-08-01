package BOJStep.If;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2480 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());
        int three = Integer.parseInt(st.nextToken());

        int money = 0;

        if (one == two && two == three) {
            money += 10000 + (one * 1000);
        } else if (one == two || one == three || two == three) {
            int same = (one == two) ? one : one == three ? one : two;
            money += 1000 + (same * 100);
        } else {
            int max = Math.max(one, Math.max(two, three));
            money = max * 100;
        }

        System.out.println(money);
    }
}
