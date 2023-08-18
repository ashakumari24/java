public class 	pra5 {
public static void main (String[] args) {
    Queen q1=new Queen();
    q1.move();
}
}
interface ChessPlayer{
    void move();
}
class Queen implements ChessPlayer
{
    public void move()
    {
        System.out.println("left,right,up,down,diagonal!");
    }
}
class king implements ChessPlayer
{
    public void move()
    {
        System.out.println("left,right,up,down");
    }
}