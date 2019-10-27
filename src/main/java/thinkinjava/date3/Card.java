package thinkinjava.date3;

public class Card extends FinalizationLog{
    Tag t1 = new Tag(1);

    Card(String name){
        System.out.println("Running Second Card's Construct:"+name);
    }
    Card(){
        System.out.println("Running First Card's Construct");
        //Tag tag= new Tag(2);
        //Card(tag);
    }


    Tag t2 = new Tag(3);

    void f(){
        System.out.println("f()");
    }

    Tag t3 = new Tag(4);
}
