package Array;

public class ArrayBigO {

   /*
   2. 배열에 대한 시간 복잡도
   - get(int idx) : idx 번째 원소 반환
     arr[i]가 가능한 이유? 메모리가 연속적이기 때문에 arr의 시작 주소로부터 idx만큼 떨어진 원소의 주소를 바로 계산하고, 접근할 수 있다.  == arr[4]
     arr[i]는 한 번에 찾을 수 있기 때문에 시간 복잡도는 0(1)  == 상수 시간 복잡도

   - change(int idx, int val) : idx번째 원소를 val로 변경
     change(4, 10);
     이 역시도 대괄호 연산자를 통해 idx에 바로 접근하고, 값을 변경할 수 있으므로 시간복잡도는 O(1)

   - append(int val) :배열의 가장 뒤에 원소 삽입, 시간 복잡도 O(1)
     현재 배열에 담긴 원소의 개수를 알면 해당 인덱스에 요청받은 원소를 넣는다.

     만약 배열이 꽉 차 있다면, append는 어떻게 동작할까?
     사이즈가 10인 배열에 9번 인덱스까지 다 차있다면, 이 연산은 불가능하다.
        이유?
        - 한 번 생성된 배열은 고정 길이이다.
        - 원소들이 연속되어 있는 배열의 마지막에 원소를 추가할 때 이미 배열이 꽉 찼다면 그보다 큰 새 배열을 생성해 옮겨 담아야 한다.

   - insert(int idx, int val) : 현재 idx 번째 원소의 앞에 원소 삽입, 배열의 중간에 원소 추가
     insert(4,5) : 기존 3번과 4번 인덱스 사이에 새로운 5라는 값을 추가, 결과적으로 5는 4번 인덱스에 추가, 기존의 4번 인덱스는 5번 인덱스의 값이 됨

     insert의 최악의 시간 복잡도는 O(N)이 될것이다.  = for문이 하나 포함되어 있음

   - erase(int idx) : idx 번째 원소 삭제
     원소들이 연속되어 있는 배열의 중간 원소를 삭제할때에는 해당 원소의 원소들을 모두 한 칸씩 앞으로 이동해야 한다.

     erase의 최악의 시간 복잡도는 O(N)이 될것이다.  = for문이 하나 포함되어 있음


     결론
     원소에 접근하고 변경하는 것은 빠르나, 중간에 원소를 추가/삭제하는 것은 배열 원소의 개소까지 시간이 걸린다.
   */

  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 3, 7, 8, 0};  // 7

    System.out.println(getElement(arr, 2));
    System.out.println(changeElement(arr, 2, 13));
    System.out.println(appendElement(arr, 6, 22));
    System.out.println(appendElement(arr, 7, 22));
  }


  public static int getElement(int[] arr, int idx) {
    return arr[idx];
  }

  public static int changeElement(int[] arr, int idx, int val) {
    return arr[idx] = val;
  }

  public static boolean appendElement(int[] arr, int arrCount, int val) {
    if (arrCount == arr.length) return false;   // 배열에 원소가 꽉 차있다.

    arr[arrCount] = val;  // 가능하다면 원소 넣어주기
    return true;
  }

  public static boolean insertElement(int[] arr, int arrCount, int idx, int val) {
    if (idx > arrCount || arrCount >= arr.length) return false;

    // i++ 로 안되는 이유는 계속 덮어씌워짐 !! arr[i+1] 값이 !! 기존값이 소실됨
    for (int i = arrCount; i > idx; i--) {  // 마지막 원소부터 idx 에 들어있는 원소까지 +1 된 인덱스 값으로 다시 세팅해줘야 함
      // 반복문의 시간 복잡도는 O(N)
      arr[i] = arr[i-1];
    }

    arr[idx] = val;

    return true;
  }

  public static boolean eraseElement(int[] arr, int arrCount, int idx) {
    if (idx >= arrCount) return false;

    // 반복문의 시간 복잡도는 O(N) = 최악의 경우
    for (int i = idx; i < arrCount; i++) {
      arr[i] = arr[i + 1];
    }
    return true;
  }

}
