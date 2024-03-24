package String;

public class anagram_02
{
    public static void main (String[] args) {
        anagram("aabbccxx", "xxyyzzbb");
        
    }
    
    // 애너그램: 단어의 구성(알파벳과 그 개수)이 완전히 같은 단어
    // 두 단어를 애너그램으로 만들기 위해 제거해야하는 문자의 최소 개수
    
    // A: "aabbcc" / b: "xxyybb"의 답은 왜 8일까?
    // A에 B에 있는 xxyy가 없음, B에 A에 있는 aacc가 없음
    // 없애야만 하는 문자 : 공통 문자를 제외한 전부
    
    public static void anagram(String a, String b) {
        int[] countA = getAlphabetCount(a);
        int[] countB = getAlphabetCount(b);
        
        int answer = 0;
        int answer2 = 0;
        
        for (int i = 0; i < 26; i++) {
            // 1. 절댓값 (차이가 나면 차이만큼 + 해주기)
            answer += Math.abs(countA[i] - countB[i]);
            
            // 2. if문으로 분기
            if (countA[i] > countB[i]) {
                answer2 += countA[i] - countB[i];
            } else if ( countB[i] > countA[i] ) {
                answer2 += countB[i] - countA[i];
            }
        }
        System.out.println(answer);
        System.out.println(answer2);
    }
    
    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26]; // 알파벳 26개, 각 알파벳의 숫자를 구하기 위한 배열
    
        for (int i = 0; i < str.length(); i ++) {
            // 알파벳을 인덱스로 하면서, 알파벳의 개수를 기록하는 배열이다.
            count[str.charAt(i) - 'a']++;
        }
    
        return count;
    }
}

