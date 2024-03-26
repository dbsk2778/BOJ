package BigONotation;

import java.util.ArrayList;
import java.util.Arrays;

public class theory
{
    // 빅오 표기법 이론 정리
    
    /**
     
     1. 시간 복잡도란?
     시간 복잡도: 입력 크기와 알고리즘간의 관계
        - 알고리즘의 복잡도를 나타내는 지표 중 하나
        - 입력 크기에 대해 프로그램의 동작시간을 가늠해볼 수 있는 수단
        - Big-O / Big-Omega / Big-Theta 와 같은 표기법으로 나타낼 수 있다. : 정의된 입력 데이터 중 가장 최악의 상황을 포함한 시간의 상한선
     
     
     2. 코딩 테스트에서의 시간 복잡도?
     - 현실에서 프로그램의 동작 시간은 환경적 요소에 따라 달라질 수 있다.
     - 보편적인 코딩 테스트에는 문제마다 시간 제한이 주어진다.
        - 해당 시간 제한이 1초라면, 최악의 테스트 케이스에서도 해당 시간 내에 프로그램이 답을 구할 수 있어야 한다.
        - 시간 제한 내에 프로그램이 종료되지 않으면 시간 초과를 받게 된다.
     - 편의상 1초에 약 1억 번 연산을 기준으로 소요시간을 가늠할 수 있다.
        - 상수/최적화 등에 따라 시간 복잡도가 1천만 밖에 되지 않아도 1초를 넘기거나 시간 복잡도로 10억이 넘어도 1초 안에 실행될 수 있다.
        - 절대적 기준이 아닌 상대적 지표
     
     
     3. 보다 적합한 알고리즘을 선택할 수 있는 기준
     - 올바른 정답을 구하는 알고리즘이 여럿이라면?
        - 시간이 넉넉하다면 구현이 쉬운 방법을 택하거나, 제한에 따라 시간/메모리상으로 효율적인 방법을 택할 수 있다.
     
     
     4. 자바의 시간 제한 - 자바는 왜 추가 시간이 있나요?
     - 같은 알고리즘을 구현했어도 언어마다 동작 시간이 다를 수 있다.
     - 대부분의 시간/메모리 제한은 C/C++ 계열 언어 기준
     - Java는 컴파일 방식으로만 동작하는 언어보다 느린편 (자바는 컴파일 + 인터프리터 같이 사용되므로 메모리 부하 있음)
     - 응시 언어가 여러가지인 경우 각 언어의 통과를 보장하기 위해 보정값이 적용될 수 있다. (보장되지 않는 경우도 있음)
     
     */


    public static void main (String[] args) {
        int[] arr = {1, 3, 666, 32, 7794, 23, 6, 11};
        
        // n이 1000만 정도보다 더 크다면 1번 사용해야 한다. (더 작다면 2번 사용해도 됨, 구현이 2번이 더 쉽기 때문)
        int result = getMaxInArray(arr);
        int result2 = getMaxInArray2(arr);
        int result3 = getMaxInArray3(arr);
        
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
    
    // 문자열의 알파벳 구성을 파악하는 코드의 시간 복잡도는?
    // 입력된 문자열 길이에 비례 = O(N), 알고리즘이 입력 크기에 비례해 선형적으로 증가 = 반복문을 기반으로 배열의 모든 원소를 순차 탐색하는 형태 = 선형탐색 시간 복잡도
    public static int[] bigOTest(String str) {
        int[] count = new int[26]; // 알파벳 26개, 각 알파벳의 숫자를 구하기 위한 배열
        
        for (int i = 0; i < str.length(); i ++) {
            // 알파벳을 인덱스로 하면서, 알파벳의 개수를 기록하는 배열이다.
            count[str.charAt(i) - 'a']++;
        }
        
        return count;
    }
    
    // 이중 반복문의 시간 복잡도는? O(N * M) = O(NM)
    public static void bigOTest2(int N, int M) {
       long sum = 0;
       for (int i = 0; i < N; i++) {
           for (int j = 0; j < M; j++) {
               sum += (long) i * j;
           }
       }
    }
    
    // 배열의 최댓값 구하기 함수 - 1. 반복문을 통해 모든 원소를 비교하는 방법
    // 이 코드의 시간 복잡도는? O(N)
    public static int getMaxInArray(int[] arr) {
        int maxValue = arr[0];
    
        for ( int j : arr )
            {
                if ( j > maxValue ) maxValue = j;
            }
        return maxValue;
    }
    
    // 배열의 최댓값 구하기 함수 - 2. 정렬 함수를 이용하는 방법
    // 이 코드의 시간 복잡도는? O(NlogN) or O(N*N) = 1번보다 더 느리다.
    public static int getMaxInArray2(int[] arr) {
        Arrays.sort(arr);  // 오름차순으로 정렬
        return arr[arr.length -1];
    }
    
    public static int getMaxInArray3(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }
}
