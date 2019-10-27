package thinkinjava.date3;

public class Arrays {
    public static void main(String[] args) {
        go();
        System.gc();
/*        System.gc();
        System.runFinalization();*/
        System.out.println("go is finish");

    }

    public static void go(){
        Card card = new Card();
        Card card1 = new Card("MyCard");
        Card[] cards = new Card[10];
        for(int i=0;i<cards.length;i++){
            switch (i){
                case 0 : cards[0] = card;break;
                case 1 : cards[1] =card1;break;
                default: break;
            }
        }

        for(int i =0; i<cards.length;i++){
            if(i==0){
                cards[0]=card1;
            }
            System.out.println("cards["+i+"]="+cards[i]);
        }
    }
}
