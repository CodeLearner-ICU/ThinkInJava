package algorithm;

public class LinkedQueue<E> implements Queue<E> {
    private int size;
    private Node head;
    private Node tail;

    public LinkedQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    private class Node{
        Node next;
        E e;
        public Node(E e,Node next){
            this.next = next;
            this.e = e;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e == null ? "null" : e.toString();
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        Node node = new Node(e);
        if(tail == null){
            tail = node;
            head = tail;
        }else {
            tail.next = node;
            tail = tail.next;
        }

        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new RuntimeException("Dequeue fail. Queue is empty.");
        }
        Node ret = head;
        head = head.next;
        ret.next = null;
        if (head == null){
            tail = null;
        }
        size --;
        return ret.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue： size=%d ",size));
        Node cur = head;
        sb.append("head{");
        while (cur != null){
            sb.append(cur+"->");
            cur = cur.next;
        }
        sb.append("null}tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if( i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
