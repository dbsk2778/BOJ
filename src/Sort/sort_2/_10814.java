package Sort.sort_2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class _10814 {

    public static void main(String[] args) throws IOException {
        sortMembers();
        sortMembers2();
    }

    // N명의 회원에 대해 나이가 증가하는 순으로, 나이가 같으면 가입한 순으로 정렬
    public static void sortMembers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 리스트 사용
//    List<Member> members = new ArrayList<>();
//
//    for (int i = 0; i < N; i++) {
//      String[] member = br.readLine().split(" ");
//      l.add(new Member(i, Integer.parseInt(member[0]), member[1]));
//    }
//
//    l.sort(new Comparator<Member>() {
//      @Override
//      public int compare(Member o1, Member o2) {
//        if (o1.getAge() == o2.getAge()) {
//          return o1.getIndex() - o2.getIndex();
//        } else {
//          return o1.getAge() - o2.getAge();
//        }
//      }
//    });

        // 배열 사용
        Member[] members = new Member[N];
        for (int i = 0; i < N; i++) {
            String[] member = br.readLine().split(" ");
            members[i] = new Member(i, Integer.parseInt(member[0]), member[1]);
        }

        // 사실 tim sort 는 stable 하므로 index 순서대로 정렬할 필요가 없음 (이미 먼저 들어온 것부터 정렬됨_
        Arrays.sort(members, Comparator.comparingInt(Member::getAge));

        for (Member m : members) {
            bw.write(m.getAge() + " " + m.getName() + "\n");
        }
        bw.flush();
    }

    // 클래스 만들기 귀찮으면 아래와 같이도 가능
    public static void sortMembers2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 배열 사용
        String[][] members = new String[N][2];
        for (int i = 0; i < N; i++) {
            members[i][0] = br.readLine();
            members[i][1] = br.readLine();
        }

        // 사실 tim sort 는 stable 하므로 index 순서대로 정렬할 필요가 없음 (이미 먼저 들어온 것부터 정렬됨_
        Arrays.sort(members, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for (String[] m : members) {
            bw.write(m[0] + " " + m[1] + "\n");
        }
        bw.flush();
    }
}
