package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1302 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> books = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String bookName = br.readLine();
            books.put(bookName, books.getOrDefault(bookName, 0) + 1);
        }

        List<String> maxSaledBooks = new ArrayList<>();
        int maxSaledCount = 0;

        for (Map.Entry<String, Integer> map : books.entrySet()) {
            if (maxSaledCount < map.getValue()) {
                maxSaledCount = map.getValue();
                maxSaledBooks.clear(); // 기존의 최댓값 들어있는 리스트 초기화
                maxSaledBooks.add(map.getKey());
            } else if (maxSaledCount == map.getValue()) {
                maxSaledBooks.add(map.getKey());
            }
        }

        Collections.sort(maxSaledBooks);

        System.out.println(maxSaledBooks.get(0));
    }
}
