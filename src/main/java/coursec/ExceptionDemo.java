package coursec;

import algorithm.Student;

import java.util.*;

public class ExceptionDemo {
    public static void main(String[] args) {
        List list = new ArrayList<Integer>();
        list.add(1);
        list.add(0,1);
        List linked = new LinkedList<Integer>();
        linked.add(1);
        Set<Integer> hash = new HashSet<>();
        hash.add(1);
        for(Integer i : hash){

        }
        Set<Student> tree = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore() - o2.getScore();
            }
        });
        tree.add(new Student("zhanshan",88));
        tree.add(new Student("lisi",43));
        for (Student s : tree){
            System.out.println(s);
        }
    }
}
