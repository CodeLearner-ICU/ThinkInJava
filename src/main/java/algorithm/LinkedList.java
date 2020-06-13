package algorithm;

/**
 * 链表，内部采用数据链接的方式，不需要提前分配空间
 * 时间复杂度分析：查询、修改：O(n)，
 * 删除：删除头节点O(1),删除尾节点O(n),平均O(n),
 * 新增：新增头节点O(1),新增尾节点O(n),平均：O(n)
 * @param <V>
 */
public class LinkedList<V> {
    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    private class Node{
        V value;
        Node next;

        public Node(V value,Node next){
            this.value = value;
            this.next = next;
        }

        public Node(V v){
            this(v,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return value.toString();
        }
    }

    public void addFirst(V v){
        /*Node node = new Node(v);
        node.next = head;
        head = node;*/
        head = new Node(v,head);

        size ++;
    }

    public void add(int index,V v){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add fail. index is illegal");
        }
        Node pre = head;
        if(index == 0){
            addFirst(v);
        }else{
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            pre.next = new Node(v,pre.next);
            size ++;
        }

    }

    /*public void add(V v){
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
        }
        cur = new Node(v);
        size ++;
    }*/

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void removeFirst(){
        head = head.next;
        size --;
    }

    public void remove(V v){
        if(isEmpty()){
            throw new RuntimeException("Error. LinkedList is Empty");
        }

        Node pre = head;
        if(pre.value.equals(v)){
            removeFirst();
        }else {
            for (int i = 0; i < size; i++) {
                if(pre.next != null && pre.next.value.equals(v)){
                    pre.next = pre.next.next;
                    size --;
                }
                pre = pre.next;
            }
        }
    }

    /*public V removeLast(){
        if(isEmpty()){
            throw new RuntimeException("Remove Error. LinkedList is Empty");
        }
        Node cur = head;
        if(cur.next == null){
            head = null;
            size --;
            return cur.value;
        }
        while (cur.next.next != null){
            cur = cur.next;
        }
        Node ret = cur.next;
        cur.next = null;
        size --;
        return ret.value;
    }*/

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LinkedList: size=%d\n",getSize()));
        Node cur = head;
        sb.append("head:");
        for (int i = 0; i < size; i++) {
            /*if (cur == null){
                break;
            }*/

            sb.append(cur.value);
            cur = cur.next;
            if (i != size -1){
                sb.append("->");
            }
        }
        //sb.append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);

            /*if(i % 4 == 3){
                linkedList.removeLast();
                System.out.println(linkedList);
            }*/
        }
        System.out.println(linkedList);
        linkedList.remove(5);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.add(3,33);
        System.out.println(linkedList);
    }
}
