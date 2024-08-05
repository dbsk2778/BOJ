package BOJStep.Level10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14215 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a == b && b == c) {
            System.out.println(a + b + c);
        } else {
            if (a > b && a > c) { // a가 max
                System.out.println(getLength(a, b ,c));
            } else if (b > a && b > c) {  // b가 max
                System.out.println(getLength(b, a, c));
            } else {  // c가 max
                System.out.println(getLength(c, a, b));
            }
        }
    }

    private static int getLength(int max, int min1, int min2) {
        if (min1 + min2 <= max) {
            max = min1 + min2 - 1;
        }
        return max + min1 + min2;
    }



    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sides = new int[3];
        sides[0] = Integer.parseInt(st.nextToken());
        sides[1] = Integer.parseInt(st.nextToken());
        sides[2] = Integer.parseInt(st.nextToken());

        // 삼각형의 세 변 정렬
        Arrays.sort(sides);

        // 가장 큰 변이 나머지 두 변의 합보다 크면 삼각형을 만들 수 없음
        if (sides[2] >= sides[0] + sides[1]) {
            sides[2] = sides[0] + sides[1] - 1;
        }

        // 세 변의 합 출력
        System.out.println(sides[0] + sides[1] + sides[2]);
    }
}
