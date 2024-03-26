package String;

import java.util.Scanner;

public class searchDoc04
{
    
    // 세준이는 영어로만 이루어진 어떤 문서를 검색하는 함수를 만들려고 한다. 이 함수는 어떤 단어가 총 몇 번 등장하는지 세려고 한다. 그러나, 세준이의 함수는 중복되어 세는 것은 빼고 세야 한다. 예를 들어, 문서가 abababa이고, 그리고 찾으려는 단어가 ababa라면, 세준이의 이 함수는 이 단어를 0번부터 찾을 수 있고, 2번부터도 찾을 수 있다. 그러나 동시에 셀 수는 없다.
    // 세준이는 문서와 검색하려는 단어가 주어졌을 때, 그 단어가 최대 몇 번 중복되지 않게 등장하는지 구하는 프로그램을 작성하시오.
    
    
    public static void main (String[] args) {
        // 1. 문서의 첫 글자부터 순회한다.
        // 2. 문서의 지금 글자부터 주어진 단어와 한글자씩 비교한다.
        // 3-1. 단어와 완전히 일치하면 개수를 올린다. 해당 단어가 등장한 이후부터 2번을 반복한다.
        // 3-2. 단어와 매치되지 않았다면 다음 글자에서 2를 반복한다.
    
        Scanner scan = new Scanner(System.in);
        String docs = scan.nextLine();  // next() 공백문자 만나면 하나의 string으로 받음, nextLine()은 개행 기준으로 새로운 string으로 받음
        String word = scan.nextLine();
    
        wordCount(docs, word);
        wordCount2(docs, word);
        wordCount3(docs, word);
        wordCount4(docs, word);
    }
    
    public static void wordCount(String docs, String word) {
        int count = 0;
        for (int i = 0; i < docs.length(); i++ ) {
            boolean isMatch = true;
            for (int j = 0; j < word.length(); j++) {
                // 주어진 인덱스 넘지 않도록 처리해주는 부분 필요 (범위 체크)
                if ( i + j >= docs.length() || docs.charAt(i+j) != word.charAt(j)){
                    // 문서에서 i번째 인덱스부터 시작하는 단어는 주어진 단어와 일치하지 않는다.
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                count++;
                // 여기서 word 길이 -1이 더해지고, 반복문이 시작되면서 1이 더 더해지니까, 단어 글자만큼 넘어감
                i += word.length() - 1;  // 해당 단어가 등장한 이후부터 2를 반복
            }
        }
    }
    
    public static void wordCount2(String docs, String word) {
        
        int startIndex = 0;  // docs의 처음 인덱스부터 시작
        int count = 0;
        
        while (true) {
            // docs 문자열의 startIndex부터 처음으로 등장하는 word 문자열 찾기 = 찾았다면 일치하는 시작 인덱를 반환, 찾지 못했다면 -1을 반환
            int findIndex = docs.indexOf(word, startIndex);  // word라는 단어를 startIndex를 시작으로 찾음
            if (findIndex < 0)
                break;
            count++;
            startIndex = findIndex + word.length();
        }
        System.out.println(count);
    }
    
    public static void wordCount3(String docs, String word) {
//         docs의 기존 길이와 word의 기존 길이가 있을테고,
//         replace 함수로 docs에 있는 word의 단어를 공백으로 대체하면, docs 길이 - (word 길이 * count) 만큼이 나올것
        int docsLength = docs.length();
        int wordLength = word.length();

        docs = docs.replace(word, "");

        int newDocsLength = docs.length();

        int count = 0;
        if (docsLength != newDocsLength) {
            int minus = docsLength-newDocsLength;
            count = minus / wordLength;
        }

        System.out.println(count);

    }
    
    public static void wordCount4(String docs, String word) {
        String replaced = docs.replace(word, "");
        int docsLength = docs.length();  // 기존 docs의 길이
        int length = docsLength - replaced.length();  // 기존 길이 - 대체된 길이 (결과적으로 word를 공백으로 대체함으로써 소거된 길이)
        
        int count = length / word.length();
        
        System.out.println(count);
    }
}
