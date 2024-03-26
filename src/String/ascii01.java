package String;

public class ascii01
{
    
    public static void main (String[] args) {
        ASCII();
        changeAlphabet("aApgmvFGAOfdfVB");
        System.out.println();
        changeAlphabet2();
    }
    
    // ASCII
    public static void ASCII() {
        char x = 65;
        System.out.println(x);  // char 형식이기 때문에 65가 나오는게 아니라 A가 나옴
        System.out.println((int)x);  // int 형식으로 변경
        System.out.println((char)65);  // char
        System.out.println(x + 25);  // int
        System.out.println((char)(x + 25));  // char
        System.out.println('Z'  - 'A');
    }
    
    
    // 소문자, 대문자 판별 + 소문자, 대문자 변경
    // ASCII 코드를 통한 대소문자 변환: base(소문자라면 'a' or 대문자라면 'A')로부터 몇 번째 알파벳(idx)인지 찾아서 더한다.
    public static void changeAlphabet(String str) {
        for (int i = 0; i < str.length(); i++) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {  // 대문자인가 (65 - 90)
                // int dist = str.charAt(i) - 'A';  // 어떤 대문자가 A와 몇 칸 떨어져 있는지 구하고, 이 값을 소문자 'a'에 더해주면 된다.
                // int lower_ascii = 'a' + dist;
                System.out.print((char)('a' + str.charAt(i) - 'A'));
            } else {  // 소문자는 'a'와의 차이를 구하고, 'A'에 더해주면 됨
                System.out.print((char)('A' + str.charAt(i) - 'a'));
            }
        }
    }
    
    // 백준 2744번
    public static void changeAlphabet2() {
        // Scanner scan = new Scanner(System.in);
        // String str = scan.next();
        
        String str = "aDFsogGEROgdr";
        
        char[] ans = str.toCharArray();
        
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('A' <= ch && ch <= 'Z') { // 대문자임을 알려면 대문자 A와 Z 사이에 있느냐를 확인하면 됨
                ans[i] = ( char ) ( 'a' + ( ch - 'A' ) );
                answer.append(( char ) ( 'a' + ( ch - 'A' ) ));
            } else {
                ans[i] = ( char ) ( 'A' + ( ch - 'a' ) );
                answer.append(( char ) ( 'A' + ( ch - 'a' ) ));
            }
        }
        
        System.out.println(ans);
        System.out.println(answer);
    }
}
