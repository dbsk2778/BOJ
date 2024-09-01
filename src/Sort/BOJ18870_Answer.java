package Sort;

import java.io.*;
import java.util.*;

public class BOJ18870_Answer {
    public static void main(String[] args) throws IOException {
        solution();
        treeSetSolution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        Map<Integer, Integer> rankMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }

        // 정렬
        Arrays.sort(sortedArr);

        // 좌표 압축: 정렬된 배열을 기준으로 순위 매기기
        int rank = 0;
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        // 원래 배열의 값을 좌표 압축한 값으로 변환
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(rankMap.get(num)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    /*
    TreeSet, Set, Map을 이용한 풀이
      1. 입력된 좌표를 작은 순으로 정렬한다. (TreeSet 순회)
      2. 정렬된 좌표를 중복을 제거하며 압축된 인덱스를 기록한다. (Set 중복제거)
      3. 입력된 좌표에 알맞은 압축 인덱스를 출력한다. (Map)
   */
    // 시간복잡도 : O(NlogN)
    public static void treeSetSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        // TreeSet은 요소를 삽입할 때 자동으로 정렬됨 (오름차순) + 중복도 제거됨
        Set<Integer> treeSets = new TreeSet<>(); // ordered collection

        // 동시에 int[] 배열에도 저장해주고, 중복을 제거하기 위해 Set에도 저장해줌
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            treeSets.add(arr[i]);
        }

        // 중복이 제거된 값에서 압축된 인덱스 저장
        // x: 입력된 값 / idx: 압축된 인덱스
        Map<Integer, Integer> sortedIndex = new HashMap<>();
        int rank = 0;
        // 작은 값부터 순회
        for (int set : treeSets) {
            sortedIndex.put(set, rank++);
        }

        for (int i = 0; i < N; i++) {
            // 키 값으로 압축된 인덱스 가져오기
            bw.write(sortedIndex.get(arr[i]) + " ");
        }
    }
}
