package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        String[][] strs = new String[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            strs[i][0] = st.nextToken();
            strs[i][1] = st.nextToken();
        }

        Arrays.sort(strs, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                // 나이 값 동일 - 들어온 순서대로 출력하는거라 나이값만 확인하면 됨
//                if (Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
//                    return o1[0].compareTo(o1[1]);
//                }
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();

        for (String[] str : strs) {
            sb.append(str[0]).append(" ").append(str[1]).append("\n");
        }

        System.out.println(sb);
    }
}
