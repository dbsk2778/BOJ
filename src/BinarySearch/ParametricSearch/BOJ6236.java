package BinarySearch.ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6236 {
    public static void main(String[] args) throws IOException {
        // 용돈 관리
        // N일 동안 사용할 금액이 주어진다. 정확히 M번 K원을 인출하여 사용할 때 계획을 만족하는 인출 금액 K의 최솟값을 구하라
        // 돈을 인출할 때 남은 돈은 다시 통장에 넣는다.
//        solution();
        solution2();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] moneys = new int[N];
        int max = 0;
        int total = 0;

        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());
            moneys[i] = money;
            total += money;
            if (max < money) max = money;
        }

        int K = findMinK(moneys, M, max, total);

        System.out.println(K);
    }

    private static int findMinK(int[] moneys, int M, int max, int total) {
        int low = max;
        int high = total;
        int K = max;

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 1; // 첫 인출 필요
            int sum = 0;

            for (int money : moneys) {
                if (sum + money > mid) { // 기존 나머지보다 사용해야 하는 돈이 클때
                    count++;
                    sum = money;
                } else {
                    sum += money;
                }
            }

            if (count > M) { // 출력해야 하는 횟수가 M보다 큼 --> 출력 횟수를 줄여야 함 --> 뽑는 돈을 늘려야 함
                low = mid + 1;
            } else {
                K = mid;
                high = mid - 1;
            }
        }

        return K;
    }

    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] useAmounts = new int[N];

        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());
            useAmounts[i] = money;
        }

        int left = 1; // 들어온 useAmount의 최댓값으로 맞춰줄 수 있음
        int right = N * 10000; // 전체 날짜에 사용할 수 있는 최댓값, 모든 일정에 다 쓸 수 있는 최댓 값, 1번 인출로 가능한 값, total 값 구해도 됨
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(useAmounts, mid, M)) { // 소비 일정 전부 다 맞춤
                // 최솟값을 찾는 문제이기 때문에 값을 줄여서 만족하는 더 작은 값이 있는지 찾아봐야 함
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    // 판정함수 : maxDrawCount를 넘기면 안되니까 drawAmount를 최대한 효율적으로 활용해야 함
    // 소비 일정을 만족할 수 있는가?
    private static boolean isPossible(int[] useAmounts, int drawAmount, int maxDrawCount) {
        int drawCount = 1; // 인출 처음 한번은 해야하니까 초기 값 1
        int currentAmount = drawAmount; // 현재 가지고 있는 돈, 출금한 돈이 얼마나 남았는지

        for (int useAmount : useAmounts) {
            // 이 조건문 안쓰고 싶다면, 들어온 useAmount의 최댓값으로 left 값을 맞춰주면 됨
            if (useAmount > drawAmount) { // 내가 출금하기로 한 금액보다 크면 출금을 몇번을 하더라도 경비 만족 불가능
                return false;
            }
            if (currentAmount < useAmount) { // 사용할 돈이 더 큼, 남은 돈에서 해결이 안될때 -> 인출 해야 함
                if (drawCount == maxDrawCount) return false;  // 인출 횟수가 내가 정한 횟수보다 작을 때 추가 인출을 하면 안되므로 false
                drawCount++;
                currentAmount = drawAmount;  // 현재 금액을 인출한 금액으로 바꿔줌
            }
            currentAmount -= useAmount; // 현재 금액에서 사용한 금액 빼주기
        }
        // useAmounts, 소비 일정을 전부 다 소화해 냈을 때 true 리턴 !!
        return true;
    }
}
