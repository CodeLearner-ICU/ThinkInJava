package algorithm;

/**
 * 动态数组
 * 时间复杂度分析：查询：O(1),修改：O(1),删除：删除第一个O(n),删除最后一个O(1),平均计算删除O(n/2)=O(n),
 * 新增：新增第一个O(n),新增最后一个O(1),平均计算新增O(n/2)=O(n),自动扩容：O(n),按均摊复杂度分析，则为O(1)
 * @param <T>
 */
public class Array<T> {
    private T[] data;

    private int size;

    public Array(int length){
        data = (T[]) new Object[length];
        this.size=0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return this.size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    /**
     * 查询下标为 i 的元素
     * @param index
     * @return
     */
    public T get(int index){
        if(index<0 || index >= size){
            throw new IllegalArgumentException("Get fail. Index is illegal");
        }
        return data[index];
    }

    public T getLast(){
        return get(size - 1);
    }

    public T getFirst(){
        return get(0);
    }

    public void set(int index,T t){
        if(index<0 || index >= size){
            throw new IllegalArgumentException("Set fail. Index is illegal");
        }
        data[index] = t;
    }

    public void add(int index,T t){
        if (size == data.length){
            resize(getCapacity()*2);
        }
        /*if(index < 0 || index >= getCapacity()){
            throw new IllegalArgumentException("Add fail. Index is illegal ");
        }错误*/
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add fail. Index is illegal");
        }
        /*for (int i = getCapacity()-1; i > index; i--) {
            data[i] = data[i-1];
        }错误*/
        for (int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = t;
        size++;
    }

    public void addLast(T t){
        add(size,t);
    }

    public void addFirst(T t){
        add(0,t);
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public T remove(int index){
        if(index<0 || index >= size){
            throw new IllegalArgumentException("Remove fail. index is illegal");
        }
        T t = data[index];
        for (int i = index + 1; i < size; i ++){
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;
        if(size == getCapacity()/4 && getCapacity()/2 != 0){
            resize(getCapacity()/2);
        }
        return t;
    }

    public T removeLast(){
        return remove(size-1);
    }

    public T removeFirst(){
        return remove(0);
    }

    public boolean removeElement(T t){
        int index = find(t);
        if(index != -1){
            remove(index);
            return true;
        }
        /*for (int i = 0; i < size; i++) {
            if (data[i].equals(t)){
                remove(i);
                return i;
            }
        }*/
        return false;
    }

    public void removeAllElement(T t){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(t)){
                remove(i);
                i--;
            }
        }
    }

    public boolean contains(T t){
        return find(t) > -1 ;
    }

    public int find(T t){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size:%d capacity:%d\n",size,data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size-1){
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>(5);
        Student student = new Student("zhangsan",57);
        Student student1 = new Student("lisi",88);
        Student student2 = new Student("zhangsan",57);
        Student student3 = new Student("wangwu",100);
        arr.addLast(student);
        arr.addLast(student1);
        arr.addLast(student2);
        arr.addLast(student3);
        arr.addLast(student3);
        arr.addLast(student3);
        arr.addLast(student3);
        System.out.println(arr);
        arr.removeElement(student);
        arr.removeElement(student1);
        //arr.removeElement(student2);
        arr.removeAllElement(student3);
        System.out.println(arr.contains(student3));
        System.out.println(arr);
    }
}
