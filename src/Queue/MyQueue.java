package Queue;


import java.util.NoSuchElementException;

class MyQueue<E> {

    private int size = 0;
    private Node<E> frontNode = null; // 추가될 곳
    private Node<E> rearNode = null; // 삭제될 곳

    public static class Node<E> {
        // item을 가지고 있고, 다음 노드만 가리키는 단일 연결 리스트
        E item;
        Node<E> next;

        // 생성자
        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    // push (제일 뒤에 원소 추가)
    public void enqueue(E element) {
        // 새로운 노드 생성, 추가될 값, 다음 값, 당연히 next 값은 null
        Node<E> newNode = new Node<>(element, null);
        rearNode.next = newNode; // rearNode의 다음 값은 새로운 노드
        rearNode = newNode; // rearNode는 새로운 노드로 변경
        size++; // 사이즈 증가
    }

    // pop (제일 앞에 있는 원소 제거)
    public E dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        E item = frontNode.item; // frontNode의 값
        frontNode = frontNode.next; // frontNode는 다음 값으로 변경

        if (frontNode == null) {
            rearNode = null; // frontNode가 null이면 rearNode도 null
        }
        size--; // 사이즈 감소
        return item;
    }

    public E getFront() {
        return frontNode.item;
    }

    public E getRear() {
        return rearNode.item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
