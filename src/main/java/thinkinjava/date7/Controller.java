package thinkinjava.date7;

class EventSet{
    private Event[] events = new Event[100];
    private int index = 0;
    private int next = 0;
    public void add(Event e){
        if(index>=events.length){
            return;
        }
        events[index++] = e;
    }
    public Event getNext(){
        boolean looped = false;
        int start = next;
        do{
            next = (next + 1) % events.length;
            if(start == next) looped = true;
            if((next == (start + 1)% events.length) && looped){
                return null;
            }
        }while (events[next] == null);
        return events[next];
    }
    public void removeCurrent(){
        events[next] = null;
    }
}
public class Controller {
    private EventSet es = new EventSet();
    public void addEvent(Event c){
        es.add(c);
    }
    public void run(){
        Event e;
        while ((e=es.getNext())!=null){
            if(e.ready()){
                e.action();
                System.out.println(e.description());
                es.removeCurrent();
            }
        }
    }

    public static void main(String[] args) {
        Controller c = new Controller();
        c.addEvent(new Event(1000) {
            @Override
            public void action() {
                System.out.println("doSomething");
            }

            @Override
            public String description() {
                return "HelloWorld";
            }
        });
        c.run();
    }
}
