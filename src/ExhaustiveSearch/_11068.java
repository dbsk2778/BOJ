package ExhaustiveSearch;

import java.util.Scanner;

public class _11068 {

  public static void main(String[] args) {
    _11068_1();
  }

  // 문제 : 주어진 숫자가 2, 64진법으로 표현했을 때, 회문인지 확인하라.
  // 회문 : 앞으로 읽으나 뒤로 읽으나 같은 문자열
  // 자릿값 표현 : 10~35는 a~z로 표현한다, 36~61은 A~Z로 표현한다. 62~63의 표현 방식은 알 필요가 없음, 어차피 같은 문자로 출력될것이므로 (판단만 하면 된다)

  // 1. 가능한 모든 진법에 대해 진법을 변환한다.
  // 2. 변환된 진법이 회문인지 확인한다.
  // 시간 복잡도 O(64 * logN)
  public static void _11068_1() {
    Scanner scan = new Scanner(System.in);
    int T = scan.nextInt();

    while (T-- > 0) {
      int x = scan.nextInt();
      boolean isPalindrome = false;
      for (int i = 2; i <= 64; i++) {  // 진법
        // String 사용하면 배열 사용할 필요가 없지만, 2자릿수 이상의 숫자 때문에 11 62 62 11 이런식으로 나오는 경우가 있어서 회문이 아니게 될 수 있기 때문에 배열을 사용한다.
        int[] baseDigit = new int[20];  // 최대 칸으로 배열 만들기, 2진수 1000000값으로 20자리가 최대이다. (2^20 = 1048576)
        int baseLength = convertBase(x, i, baseDigit);  // x를 i진법으로 변환한다.
        if (isPalindrome(baseDigit, baseLength)) {
          isPalindrome = true;  // 하나라도 답에 해당되면 true
          break;
        }
      }
      System.out.println(isPalindrome ? "1" : "0");

    }
  }

  // 가능한 모든 진법에 대해 진법을 변환한다.
  // 시간 복잡도 O(logN)
  public static int convertBase(int x, int base, int[] reverseDigit) {
    // int[] reverseDigit = new int[20];  // 최대 칸으로 배열 만들기, 2진수 1000000값으로 20자리가 최대이다. (2^20 = 1048576)
    // 만약 위처럼 배열의 수를 정해놓는다면, 회문 판단시 배열이 어디서부터 어디까지 채워졌는지 알아야 한다. 그래서 배열은 파라미터로 받고 길이를 반환하는 것이 좋다.
    int len = 0;

//    // 배열의 len을 여기서 구해주고 아래와 같이 reverseDigit를 선언해줘도 된다.
//    int copyX = x;  // x 값을 직접적으로 건드리지 말기.
//    while (copyX > 0) {
//      copyX /= base;  // 몫
//      len++;
//    }
//
//    int[] reverseDigit = new int[len];

    while (x > 0) {
      reverseDigit[len++] = x % base;  // 나머지
      x /= base;  // 몫
    }
    return len;
  }

  // 변환된 수가 회문이 될 수 있는지 확인한다.
  // 가운데를 기준으로 대칭이 되는지 확인한다.
  // 시간 복잡도 O(logN)
  public static boolean isPalindrome(int[] digit, int length) {
    // length 안받고 digit 배열만 받았다면 digit.length로 받아도 된다.
    for (int i = 0; i < length / 2; i++) {
      // i가 0일때 매칭되어야 하는 오른쪽 인덱스 값은 len - i - 1이다.
      if (digit[i] != digit[length - i - 1]) {
        return false; // 다른 자리 값이 하나라도 있으면 회문이 아니다.
      }
    }
    return true;
  }
}
