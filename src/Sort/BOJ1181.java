package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            set.add(word);
        }

        // new String[0]은 set에 있는 요소들을 새로운 String 배열에 복사할 때 반환될 배열의 타입을 지정해주기 위해 사용

        String[] strs = set.toArray(new String[0]);

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < set.size() - 1; i++) {
            sb.append(strs[i]).append("\n");
        }
        sb.append(strs[set.size() - 1]);

        System.out.println(sb);
    }
}
