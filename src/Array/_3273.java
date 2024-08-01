package Array;

import java.io.*;
import java.util.Scanner;

public class _3273 {

    // 서로 다른 양의 정수로 이루어진 수열에서 두 수의 합이 X가 되는 쌍의 개수
    public static void main(String[] args) throws IOException {
        sum();
        sum2();
    }


    /**
     * 쌍의 개수라는 문제에서 만약 아무런 제한이 없으면 아래와 같은 이중 for문을 사용하면 된다. 시간 복잡도 O(n^2) = 시간 초과
     * 틀렸음 !!
     */
    public static void sum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");

        int M = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Integer.parseInt(arr[i]) + Integer.parseInt(arr[j]) == M) {
                    count++;
                }
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }

    // 실질적으로 어떻게 모든 쌍을 보지 않고 문제를 풀 수 있을것인가에 대한 고민이 필요함.
    // 바깥 반복문은 그대로 두고, X- arr[i]가 있는지 확인하는 방법을 사용하면 시간 복잡도를 줄일 수 있다.
    public static void sum2() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }
        int X = scan.nextInt();

        boolean[] exist = new boolean[10000001]; // 들어올 수 있는 값의 최대 범위, 백만도 인덱스로 써야하기 때문에 +1로 설정

        // 시간 복잡도는 O(N)
        for (int i = 0; i < N; i++) {
            exist[a[i]] = true;
        }

        int ans = 0;

        // 모든 newArr[i]에 대해 X - newArr[i]가 존재하는지 확인
//    for (int i = 0; i < N; i++) {
//      int pairValue = X - newArr[i];
//
//      if (pairValue >= 0 && pairValue <= 10000000) {  // 인덱스의 범위 체크
//        ans += exist[pairValue] ? 1 : 0;
//      }
//    }

//    bw.write(ans / 2 + "\n");  // 중복 값 발생 가능

        // 중복 방지
        for (int i = 0; i <= (X - 1) / 2; i++) {
            if (i <= 1000000 && X - i <= 1000000) {
                ans += (exist[i] && exist[X - i]) ? 1 : 0;  // 둘 다 true일 때만 1을 더함
            }
        }
        System.out.println(ans);
    }
}
