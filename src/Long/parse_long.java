package Long;

import java.util.Scanner;

public class parse_long
{
    
    public static void main (String[] args) {
        splitTest();
    }
    
    // 입력값의 최대 범위가 10의 12승 = java의 int 양의 정수 표현 범위는 2의 31승 -1
    // 그러므로 10의 12승은 자바의 int에 저장될 수 없음
    public static void splitTest() {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strs = str.split(" ");
        System.out.println(java.lang.Long.parseLong(strs[0]) + java.lang.Long.parseLong(strs[1]) + java.lang.Long.parseLong(strs[2]));
    }
}
