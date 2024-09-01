package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2910 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        // LinkedHashMap은 삽입된 순서를 유지하므로, 빈도수가 동일한 경우 처음 등장한 순서대로 기본적으로 출력 가능
        // HashMap은 순서 유지하지 않음 !! 만약 순서가 중요할 경우라면 LinkedHashSet 사용하기
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        list.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : list) {
            int count = entry.getValue();

            while (count-- > 0) {
                sb.append(entry.getKey()).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
