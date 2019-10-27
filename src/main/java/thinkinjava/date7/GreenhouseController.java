package thinkinjava.date7;

public class GreenhouseController extends Controller {
    private boolean light = false;
    private boolean water = false;
    private String thermostat = "Day";
    private class LightOn extends Event{
        public LightOn(long longTime){
            super(longTime);
        }
        public void action() {
            light = true;
        }

        public String description() {
            return "Light is on";
        }
    }
    private class LightOff extends Event{
        public LightOff(long longTime){
            super(longTime);
        }
        public void action() {
            light = false;
        }

        public String description() {
            return "Light is off";
        }
    }

    private class WaterOn extends Event{

        public WaterOn(long longTime) {
            super(longTime);
        }

        public void action() {
            water = true;
        }

        public String description() {
            return "Greenhouse water is on";
        }
    }

    private class WaterOff extends Event{

        public WaterOff(long longTime) {
            super(longTime);
        }

        public void action() {
            water = false;
        }

        public String description() {
            return "Greenhouse water is off";
        }
    }

    private class ThermostatNight extends Event{
        public ThermostatNight(long longTime) {
            super(longTime);
        }

        public void action() {
            thermostat = "Night";
        }

        public String description() {
            return "Thermostat on night setting";
        }
    }

    private class ThermostatDay extends Event{
        public ThermostatDay(long longTime) {
            super(longTime);
        }

        public void action() {
            thermostat = "Day";
        }

        public String description() {
            return "Thermostat on day setting";
        }
    }

    private int rings;
    private class Bell extends Event{
        public Bell(long longTime) {
            super(longTime);
        }

        public void action() {
            System.out.println("Bing!");
            if(--rings>0){
                addEvent(new Bell(System.currentTimeMillis()+2000));
            }
        }

        public String description() {
            return "Ring bell";
        }
    }
    private class Restart extends Event{
        public Restart(long longTime) {
            super(longTime);
        }

        public void action() {
            long tm = System.currentTimeMillis();
            rings = 5;
            addEvent(new ThermostatNight(tm));
            addEvent(new LightOn(tm+1000));
            addEvent(new LightOff(tm +2000));
            addEvent(new WaterOn(tm +3000));
            addEvent(new WaterOff(tm+8000));
            addEvent(new Bell(tm+9000));
            addEvent(new ThermostatDay(tm+10000));
            addEvent(new Restart(tm+20000));
        }

        public String description() {
            return "Restarting system";
        }
    }

    public static void main(String[] args) {
        GreenhouseController gc = new GreenhouseController();
        long tm = System.currentTimeMillis();
        gc.addEvent(gc.new Restart(tm));
        gc.run();
    }
}
