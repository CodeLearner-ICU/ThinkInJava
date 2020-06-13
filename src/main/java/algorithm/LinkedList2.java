package algorithm;

/**
 * 链表，内部采用数据链接的方式，不需要提前分配空间
 * 时间复杂度分析：查询、修改：O(n)，
 * 删除：删除头节点O(1),删除尾节点O(n),平均O(n),
 * 新增：新增头节点O(1),新增尾节点O(n),平均：O(n)
 * @param <V>
 */
public class LinkedList2<V> {
    private Node dummyHead = new Node();
    private int size;

    public LinkedList2(){
        /*dummyHead.next = null;*/
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
            return value == null ? "" : value.toString();
        }
    }

    public void add(int index,V v){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add fail. index is illegal");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(v,pre.next);
        size ++;

    }

    public void addFirst(V v){
        add(0,v);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void remove(V v){
        if(isEmpty()){
            throw new RuntimeException("Error. LinkedList is Empty");
        }

        Node pre = dummyHead;
        for (int i = 0; i < size; i++) {
            if(pre.next != null && pre.next.value != null && pre.next.value.equals(v)){
                pre.next = pre.next.next;
                size --;
            }
            pre = pre.next;
        }
    }

    public V remove(int index){
        if(index<0 || index >= size){
            throw new IllegalArgumentException("Remove fail.Index is illegal. ");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node ret = pre.next;
        pre.next = ret.next;
        ret.next = null;
        size --;
        return ret.value;
    }

    public V get(int index){
        if(index <0 || index>=size){
            throw new IllegalArgumentException("Get fail.Index is illegal");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    public boolean contains(V v){
        Node cur = dummyHead.next;
        /*for (int i = 0; i < size; i++) {
            if(cur != null && cur.value != null && cur.value.equals(v)){
                return true;
            }
            cur = cur.next;
        }*/
        while (cur != null){
            if(cur.value != null && cur.value.equals(v)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void set(int index,V v){
        if(index <0 || index>=size){
            throw new IllegalArgumentException("Set fail.Index is illegal");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.value = v;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LinkedList: size=%d\n",getSize()));
        sb.append("head:");
        for(Node cur = dummyHead.next;cur != null;cur = cur.next){
            sb.append(cur + "->");
        }
        sb.append("null");
/*        for (int i = 0; i < size; i++) {
            sb.append(cur.value);
            cur = cur.next;
            if (i != size -1){
                sb.append("->");
            }
        }*/
        //sb.append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList2<Integer> linkedList = new LinkedList2<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(0,i);

            /*if(i % 4 == 3){
                linkedList.removeLast();
                System.out.println(linkedList);
            }*/
        }
        System.out.println(linkedList);
        linkedList.remove(5);
        System.out.println(linkedList);
        linkedList.add(3,33);
        System.out.println(linkedList);
        linkedList.addFirst(null);
        System.out.println(linkedList);
        System.out.println(linkedList.contains(33));
    }
}
