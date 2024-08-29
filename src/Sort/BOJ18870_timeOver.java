package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18870_timeOver {
    public static void main(String[] args) throws IOException {
//        solution();
        solution2();
    }

    // 시간초과 발생
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int token = Integer.parseInt(st.nextToken());
            arr[i] = token;
            set.add(token);
        }

        int[] newArr = new int[N];

        for (int i = 0; i < N; i++) {
            int count = 0;
            // set.stream().toList()는 자바 11에서는 불가능
            List<Integer> list = new ArrayList<>(set);
            for (int j : list) {
                if (j < arr[i]) count++;
            }
            newArr[i] = count;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) sb.append(newArr[i]).append(" ");

        System.out.println(sb);
    }

    // 시간 초과
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int token = Integer.parseInt(st.nextToken());
            arr[i] = token;
            set.add(token);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        for (int i : arr) {
            // list.indexOf() 메서드는 리스트 길이에 대한 선형 시간 복잡도를 가지므로 큰 입력에 대해 매우 느리게 동작함
            sb.append(list.indexOf(i)).append(" ");
        }

        System.out.println(sb);
    }
}
