public class 	pra1 {
public static void main (String[] args) {
    Pen p1=new Pen();
    p1.setColor("Blue");
    p1.getcolor();
}
}
class Pen
{
    private String color;
    private int tip;
    // Setters
    void setColor(String cl)
    {
        this.color=cl;
    }
    void SetTip(int tp)
    {
        this.tip=tp;
    }
    // Getters
    void getcolor()
    {
        System.out.println(this.color);
    }
    void gettip()
    {
        System.out.println(this.tip);
    }
}