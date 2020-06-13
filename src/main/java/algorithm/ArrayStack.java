package algorithm;

/**
 * 基于数组实现的栈
 * 时间复杂度分析：不支持查询、修改（底层基于数组，查询修改复杂度与数组一致），出栈：O(1),入栈：O(1)
 */
public class ArrayStack<E> implements Stack<E>{
    private Array<E> data;

    public ArrayStack(int capacity){
        data = new Array<>(capacity);
    }

    public ArrayStack(){
        /*this(10);*/
        data = new Array<>();
    }

    @Override
    public boolean isEmpty(){
        return data.isEmpty();
    }

    @Override
    public int getSize(){
        return data.getSize();
    }

    @Override
    public void push(E e){
        data.addLast(e);
    }

    @Override
    public E pop(){
        return data.removeLast();
    }

    @Override
    public E peek(){
        return data.getLast();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:");
        sb.append("[");
        for (int i = 0; i < data.getSize(); i++) {
            sb.append(data.get(i));
            if (i != data.getSize() - 1){
                sb.append(",");
            }
        }
        sb.append("] top");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
