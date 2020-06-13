package algorithm;

public class LinkedListRecursion<E> {
    private int size;
    private Node dummyHead;
    private class Node{
        E value;
        Node next;

        public Node(E value, Node next){
            this.value = value;
            this.next = next;
        }

        public Node(E v){
            this(v,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return value == null ? "" : value.toString();
        }
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E getFirst(){
        if (isEmpty()){
            throw new RuntimeException("Error. LinkedList is empty.");
        }
        return dummyHead.next.value;
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get fail.Index is illegal.");
        }
        return get(index,dummyHead.next).value;
    }

    private Node get(int index, Node cur) {
        if (index == 0){
            return cur;
        }
        return get(index--,cur.next);
    }

    public void addFirst(E e){
        /*Node node = new Node(e);
        node.next = dummyHead.next;*/
        dummyHead.next = new Node(e,dummyHead.next);
    }

    public void add(int index,E e){

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LinkedListRecursion,size=%d head{",size));
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            sb.append(cur+"->");
        }
        sb.append("NULL}");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListRecursion<Integer> linkedList = new LinkedListRecursion<>();
        for (int i = 0; i < 10; i++) {
            //linkedList.add(0,i);

            /*if(i % 4 == 3){
                linkedList.removeLast();
                System.out.println(linkedList);
            }*/
        }
  /*      System.out.println(linkedList);
        linkedList.remove(5);
        System.out.println(linkedList);
        linkedList.add(3,33);
        System.out.println(linkedList);
        linkedList.addFirst(null);
        System.out.println(linkedList);
        System.out.println(linkedList.contains(33));*/
    }
}
