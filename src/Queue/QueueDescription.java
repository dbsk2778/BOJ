package Queue;

public class QueueDescription {

    /*
     * LinkedList를 이용한 Queue 구현 **
     * Queue(큐): 먼저 넣은 데이터가 먼저 나오는 선입선출 자료구조 (FIFO)
     *  - 대기열의 가장 뒤에 원소가 추가되고, 가장 앞의 원소부터 처리됨
     *  - 요청의 입력/도달 순서대로 처리하는 상황에 유용 **
     *  ex. 티케팅 대기열, 프린터 대기열, 운영체제 스케줄링, 메시지 큐 등
     * <p>
     * // 삽입
     *  add(): 큐의 뒤쪽에 원소를 추가, 큐에 공간이 없다면 Exception 발생
     *  offer(): 큐의 뒤쪽에 원소를 추가, 큐에 공간이 없다면 false 반환
     *  // 삭제
     *  remove(): 큐의 첫 번째 원소(head 원소)를 제거하고 반환, 큐가 비어있다면 Exception 발생
     *  poll(): 큐의 첫 번째 원소(head 원소)를 제거하고 반환, 큐가 비어있다면 null 반환
     *  // 확인
     *  element(): 큐의 첫 번째 원소를 반환, 큐가 비어있다면 Exception 발생
     *  peek(): 큐의 첫 번째 원소를 반환, 큐가 비어있다면 null 반환
     * <p>
     *
     *  *** LinkedList를 이용한 Queue 구현
     *  - LinkedList의 맨 앞을 front, 맨 뒤를 rear로 설정
     *  - front: 큐의 맨 앞 원소를 가리키는 포인터
     *  - rear: 큐의 맨 뒤 원소를 가리키는 포인터
     *  - enqueue: rear가 가리키는 곳에 원소 추가 (addLast()를 이용해 리스트의 가장 마지막에 원소를 추가한다.)
     *  - dequeue: front가 가리키는 원소를 제거하고 front를 다음 원소로 이동 (removeFirst()를 이용해 리스트의 첫 번째 원소를 제거한다.)
     * <p>
     *
     *  *** Array(배열) 기반의 Queue 구현 = Size가 정해진 Queue
     *  - enqueue: rearIndex에 원소를 추가하고, rearIndex를 1 증가시킨다. (rearIndex = (rearIndex + 1) % MAX_SIZE)
     *  - dequeue: frontIndex에 있는 원소를 제거하고, frontIndex를 1 증가시킨다. (frontIndex = (frontIndex + 1) % MAX_SIZE)
     * <p>
     *
     *  *** java.util.Queue 인터페이스
     *  // FIFO 특징을 지닌 큐의 가장 기본적인 구현체인 LinkedList를 이용해 Queue를 생성
     *  Queue<Integer> queue = new LinkedList<>();
     *
     * <p>
     *  - Queue 인터페이스는 Collection 인터페이스를 상속받는 인터페이스로, Queue를 구현한 클래스는 다음과 같은 메소드를 제공한다.
     *  - add(E e): 큐의 뒤쪽에 원소를 추가, 큐에 공간이 없다면 Exception 발생
     *  - offer(E e): 큐의 뒤쪽에 원소를 추가, 큐에 공간이 없다면 false 반환
     *  - remove(): 큐의 첫 번째 원소(head 원소)를 제거하고 반환, 큐가 비어있다면 Exception 발생
     *  - poll(): 큐의 첫 번째 원소(head 원소)를 제거하고 반환, 큐가 비어있다면 null 반환
     *  - element(): 큐의 첫 번째 원소를 반환, 큐가 비어있다면 Exception 발생
     *  - peek(): 큐의 첫 번째 원소를 반환, 큐가 비어있다면 null 반환
     */
}

