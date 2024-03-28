package String;

import java.util.Scanner;

public class alphabet03
{
    // 1157. 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String lowerAlphabet = str.toLowerCase();
        
        int[] count = new int[26];
    
        for (int i = 0; i < lowerAlphabet.length(); i++) {
            char ch = lowerAlphabet.charAt(i);
            count[ch - 'a']++;
        }
        
        int maxCount = -1;
        char maxAlphabet = '?';
        
        for (int i = 0; i < 26; i++) {
            if ( count[i] > maxCount ) {
                maxCount = count[i];
                maxAlphabet = (char)('A' + i);
            } else if (count[i] == maxCount) {
                maxAlphabet = '?';
            }
        }
        System.out.println( maxAlphabet);
    }
}
