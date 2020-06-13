package algorithm;

/**
 * 数组队列，底层基于动态数组的实现
 * 时间复杂度分析：不支持查询、修改(复杂度同数组)，入队：从数组末尾添加元素，O(1)，出队：从数组第一个元素取出，取出后需要移动数组，时间复杂度O(n)
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> data;

    public ArrayQueue(int capacity){
        data = new Array<>(capacity);
    }

    public ArrayQueue(){
        /*this(10);*/
        data = new Array<>();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    public int getCapacity(){
        return data.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        sb.append("front [");
        for (int i = 0; i < data.getSize(); i++) {
            sb.append(data.get(i));
            if(i != data.getSize() - 1){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if( i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
