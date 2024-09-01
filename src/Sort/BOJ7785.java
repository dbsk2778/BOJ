package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7785 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Map<String, String> maps = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            maps.put(st.nextToken(), st.nextToken());
        }

        List<String> enteredPerson = new ArrayList<>();

        for (Map.Entry<String, String> map : maps.entrySet()) {
            if (map.getValue().equals("enter")) enteredPerson.add(map.getKey());
        }

        enteredPerson.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (String str : enteredPerson) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
