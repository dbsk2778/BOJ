package Array;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class _10989 {

    // N(10,000,000)개의 자연수 ([1, 10000])가 주어질 때 오름차순으로 정렬한 결과를 출력
    // 삽입 정렬? Arrays.sort()? 이 두가지 정렬의 최악의 시간 복잡도는 O(n^2)이지만, Arrays.sort()가 더 빠르다.
    // 만약 O(N^2)의 시간 복잡도로 10,000,000 이 값을 받게 되면, 100,000,000,000,000 이므로 시간 초과가 날 수 있다.

    public static void main(String[] args) throws IOException {
        sortArr();
        countArr();
        countArr_2();
        _15552();
    }

    // int형으로 하면 배열 크기 때문에 손실이 날 수 있음. long으로 해야함.
    public static void sortArr() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int M = scan.nextInt();
            arr[i] = M;
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }

    // 시간 복잡도 (O(N) 10,000,000) 계산된 시간 복잡도가 실제 복잡도 아님, 추정 시간일뿐
    // 제출 시 시간 초과 일어남

    // 입출력 함수가 병목이 될 수 있다. scanner. system.out.println 상대적으로 매울 느림.
    public static void countArr() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] cnt = new int[10001]; // 주어진 배열의 최대 크기가 10000이므로 10001으로 설정

        for (int i = 0; i <= N; i++) {  // 시간 복잡도 O(N)
            cnt[scan.nextInt()]++;
        }

        for (int i = 0; i <= 10000; i++) {  // 시간 복잡도 O(max(10000, N))
            while (cnt[i]-- > 0) { // cnt[i]가 존재할때까지
                System.out.println(i);
            }
        }
    }

    public static void countArr_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10001];

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= 10000; i++) {
            while (arr[i]-- > 0) {
                bw.write(i + "\n");
            }
            bw.flush();
        }
    }

    // 빠른 A+b 15552번 문제 참고
    // Scanner와 System.out.println을 사용하지 않고 BufferedReader와 BufferedWriter를 사용
    // 1,000,000 단위 이상일경우 Scanner, System.out.println을 사용하지 않기.
    public static void _15552() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(
                br.readLine());  // bufferedReader은 Line 단위로만 받을 수 있기 때문에, String 값임 + IOException 처리

        while (T-- > 0) {
            String[] arr = br.readLine().split(" ");
            int A = Integer.parseInt(arr[0]);
            int B = Integer.parseInt(arr[1]);

            bw.write(A + B + "\n");  // bufferWriter는 write로 출력 + "\n"으로 개행 (이 코드로 바로 출력되는 게 아님)
        }
        bw.flush();  // bufferWriter는 flush()로 출력
    }
}
