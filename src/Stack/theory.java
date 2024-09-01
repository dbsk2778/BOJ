package Stack;

public class theory {

    // Deque 사용하기 !!!

    /** 큐는 선입선출 (먼저 넣은 데이터가 먼저 나옴)
     * 스택은 마지막에 넣은 데이터가 먼저 나오는 후입선출 자료구조 (Last In First Out)
     * 대기열의 가장 위에 원소가 추가되고, 가장 위의 원소부터 처리됨 (기록을 쌓아가며 직전의 상태를 복원해야 하는 상황에 유리)
     * ex. 웹 브라우저 뒤로 가기, 프로그램 실행 취소(ctrl-z), 함수 호출 등
     *
     * java.util.Stack은 Vector을 상송하는 클래스로 동기화 오버헤드가 존재, 코딩 테스트에서는 잘 쓰이지 않음 !!
     * Stack 대신 Deque를 통해 구현하는 걸 권장 (Deque는 인덱스 기반 접근을 제공하지 않음, 양 끝에서 삽입 삭제가 가능하므로 Queue와 Stack 모두 사용 가능)
     * addFirst() = push() 용도 + removeFirst() = pop() 용도로 사용하면 stack으로 사용 가능
     * or addLast() + removeLast() 이 두가지를 사용하여도 stack으로 사용 가능
     *
     * Stack의 구현에는 LinkedList 기반의 Stack 구현과 Array 기반의 Stack 구현이 있음
     * 1. LinkedList 기반의 Stack 구현
     * 1) push : addLast를 사용해 리스트의 가장 마지막에 원소를 추가한다.
     * 2) pop : removeLast를 사용해 릿트의 가장 뒷 원소를 삭제한다.
     *
     * 2. Array 기반의 Stack 구현
     * 1) push : topIndex를 증가시키고 원소를 추가한다.
     * 2) pop : topIndex의 원소를 삭제하고 topIndex를 감소시킨다.
     * - size를 따로 관리하지 않아도 topIndex를 통해 알 수 있다.
     * - 최대 범위 배열을 만들어두고 topIndex만 관리하면 비교적 간단히 사용할 수 있다.
     */
}
