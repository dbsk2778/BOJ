package BinarySearch.BOJ2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ2470_Set {
    // 음수에서 두개, 양수에서 두개 이렇게 뽑을수도 있음 !!
    public static void main(String[] args) throws IOException {
         setSolution();
    }

    // 시간 초과 - 시간복잡도 O(N2)
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int[] mins = new int[2];

        for (int i = 0; i < N; i++) {
            // 서로 다른 용액이니까 i + 1부터 시작함 !!
            for (int j = i + 1; j < N; j++) {
                int currentAbs = Math.abs(arr[i] + arr[j]);
                if (currentAbs < min) {
                    min = currentAbs;
                    mins[0] = arr[i];
                    mins[1] = arr[j];
                }
            }
        }

        Arrays.sort(mins);

        System.out.println(mins[0] + " " + mins[1]);
    }

    // TreeSet의 floor와 ceiling을 사용하면 찾고자 하는 값과 가장 가까운 값을 찾을 수 있음
    // 시간 복잡도 O(NlogN)
    public static void setSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answerAbs = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = 0;

        // HashSet은 floor, ceiling 메서드 없음.
        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            // 들어오는 순서대로 set에 추가 !!
            int x = Integer.parseInt(st.nextToken());

            // floor은 이 값과 가장 가깝되, 이 값 이하인 숫자
            // ceiling은 이 값과 가장 가깝되, 이 값 이상인 숫자
            // pairValues는 x에 대해서 -x가 있으면 가장 좋지만, 아닐 경우 -x와 가까운 양 옆의 두 숫자를 보게 됨
            // WapperClass로 받은 이유는 저 floor, ceiling 값이 없을때 null을 반환하기 위해 (최댓값에 대한 ceiling 값, 최솟값에 대한 floor 값 없음)
            Integer[] pairValues = {set.floor(-x), set.ceiling(-x)};

            for (Integer pairValue : pairValues) {
                if (pairValue == null) continue;
                int sumAbs = Math.abs(x + pairValue);
                if (answerAbs > sumAbs) {
                    answerAbs = sumAbs;
                    answer1 = x;
                    answer2 = pairValue;
                }
            }
            // pairValue를 조사할 때 x 값이 있으면 안됨, 당연히 가장 가까운 값이 x일테니,
            // 그래서 모든 로직 끝나고 추가해 줘야함
            set.add(x);
        }

        System.out.println(answer1 + " " + answer2);
    }
}
