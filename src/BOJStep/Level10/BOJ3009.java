package BOJStep.Level10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ3009 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            putNum(mapA, a);
            putNum(mapB, b);
        }

        findUnique(mapA);
        findUnique(mapB);
    }

    private static void putNum(Map<Integer, Integer> map, int num) {
//        if (!map.containsKey(num)) {
//            map.put(num, 1);
//        } else {
//            map.put(num, map.get(num) + 1);
//        }
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    private static void findUnique(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}
