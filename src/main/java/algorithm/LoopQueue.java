package algorithm;

/**
 * 循环队列，底层基于自己实现的动态数组
 * 时间复杂度分析：不支持查询、修改（实现的话也是O(1)），入队：O(1),出队：O(1)
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E>{
    private E[] data;

    private int front;

    private int tail;

    private int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1)% data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        /*int i = 0;
        while (front != ((tail + 1)%getCapacity())){
            newData[i] = data[front];
            i++;
            front = front++ % getCapacity();
        }*/
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front+i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        /*if(size < getCapacity()/4 && getCapacity()/2 !=0){
            resize(getCapacity()/2);
        }*/
        if(size == getCapacity()/4 && getCapacity()/2 !=0){
            resize(getCapacity()/2);
        }
        return e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        return data[front];
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue： size=%d, capacity=%d\n",size,getCapacity()));
        sb.append(String.format("front:%d [",front));
        /*for (int i = front%getCapacity(); i != (tail+1)%getCapacity(); i++) {
            sb.append(data[i]);
            if(i != (tail+2)%getCapacity()){
                sb.append(", ");
            }
            i = i %getCapacity();
        }*/
        for (int i = 0; i < size; i++) {
            sb.append(data[(i+front)%data.length]);
            if(i != size - 1){
                sb.append(", ");
            }
        }
        sb.append(String.format("] tail：%d",tail));
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<>();
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
