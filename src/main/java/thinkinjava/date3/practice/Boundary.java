package thinkinjava.date3.practice;

public class Boundary {
    private String privateData = "privateData";

    /**
     * 包内及其子类可见
     */
    protected String protectedData = "protectedData";

    String friendlyData = "friendlyData";

    public String publicData ="publicData";
}
class BoundaryTest{
    public static void main(String[] args) {
        Boundary boundary = new Boundary();
        System.out.println(boundary.protectedData);
    }
}
