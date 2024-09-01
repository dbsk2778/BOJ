package Queue.deque;

public class DequeDescription {



    /*
     * 양 끝의 삽입/삭제를 제공하는 Collection Queue의 확장 인터페이스. Stack을 대체하여 사용 (인덱스 기반 접근을 제공하지 않음)
     *
     * Deque(Double-ended Queue) **
     * - 양쪽 끝에서 원소를 삽입/삭제 할 수 있는 양방향 Queue
     * - push/pop을 각각 addLast/removeLast로만 이용하면 FIFO
     * - Queue는 단방향 List 만으로 구현할 수 있지만, Deque는 양방향 List로 구현해야 함(prev, next 모두 관리 필요)
     *
     * 구현
     *
     * Deque<Integer> deque = new LinkedList<>();
     *
     * - addFirst(E e): Deque의 앞쪽에 원소를 추가, 덱에 공간이 없다면 Exception 반환
     * - addLast(E e): Deque의 뒤쪽에 원소를 추가, 덱에 공간이 없다면 Exception 반환
     * - offerFirst(E e): Deque의 앞쪽에 원소를 추가, 덱에 공간이 없다면 false 반환
     * - offerLast(E e): Deque의 뒤쪽에 원소를 추가, 덱에 공간이 없다면 false 반환
     * - removeFirst(): Deque의 앞쪽 원소를 제거하고 반환, 덱이 비어있다면 Exception 반환
     * - removeLast(): Deque의 뒤쪽 원소를 제거하고 반환, 덱이 비어있다면 Exception 반환
     * - pollFirst(): Deque의 앞쪽 원소를 제거하고 반환, 덱이 비어있다면 null 반환
     * - pollLast(): Deque의 뒤쪽 원소를 제거하고 반환, 덱이 비어있다면 null 반환
     * - getFirst(): Deque의 앞쪽 원소를 반환, 덱이 비어있다면 Exception 반환
     * - getLast(): Deque의 뒤쪽 원소를 반환, 덱이 비어있다면 Exception 반환
     * - peekFirst(): Deque의 앞쪽 원소를 반환, 덱이 비어있다면 null 반환
     * - peekLast(): Deque의 뒤쪽 원소를 반환, 덱이 비어있다면 null 반환
     *
     *
     * LinkedList를 이용한 Deque 구현
     * - addFirst/addLast: 리스트의 가장 앞, 뒤에 새 노드를 연결하여 추가한다.
     * - removeFirst/removeLast: 리스트의 가장 앞, 뒤 노드에 대한 연결을 끊어 삭제한다.
     *
     * Array 기반의 Deque 구현
     * - addFirst/Last: first/lastIndex에 원소를 추가하고 인덱스를 이동한다.
     * - removeFirst/Last: first/lastIndex에 있는 원소를 제거하고 인덱스를 이동한다.
     */
}
